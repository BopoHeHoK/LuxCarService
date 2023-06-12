package com.test.luxcarservice.app.presentation.screen.services

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.date.dayOfMonth
import com.afollestad.date.month
import com.afollestad.date.year
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.dateTimePicker
import com.test.luxcarservice.R
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.app.presentation.adapter.ServiceAdapter
import com.test.luxcarservice.databinding.FragmentServicesBinding
import com.test.luxcarservice.domain.model.Appointment
import com.test.luxcarservice.domain.model.Notification
import com.test.luxcarservice.domain.model.Service
import java.util.Calendar
import javax.inject.Inject

class ServicesFragment : Fragment(), ServiceAdapter.Listener {

    @Inject
    lateinit var servicesViewModelFactory: ServicesViewModelFactory

    private lateinit var binding: FragmentServicesBinding
    private lateinit var servicesViewModel: ServicesViewModel
    private lateinit var serviceAdapter: ServiceAdapter

    private var date = ""
    private var time = ""

    private var role = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectServicesFragment(
            servicesFragment = this
        )
        servicesViewModel = ViewModelProvider(
            owner = this,
            factory = servicesViewModelFactory
        )[ServicesViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentServicesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeServices()
        onAddButtonClick(view)
        toAddService(view)
    }

    private fun addServiceAdapter() {
        serviceAdapter = ServiceAdapter(this, role)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = serviceAdapter
        }
    }

    private fun observeServices() {
        servicesViewModel.apply {
            role = getRoles()[getRoles().indexOf(getRoles().firstOrNull {
                it.id == getUser(getUserId()).role_id
            })].role.toString()
            if (role == "STAFF") {
                binding.add.visibility = View.VISIBLE
            }
            addServiceAdapter()
            serviceAdapter.setServiceList(getServices())
        }
    }

    private fun onAddButtonClick(view: View) {

    }

    override fun onRemoveClick(service: Service) {
        servicesViewModel.deleteService(service.id)
    }

    override fun onServiceClick(service: Service) {
        servicesViewModel.apply {
            view?.let {
                MaterialDialog(it.context).show {
                    dateTimePicker(show24HoursView = true) { dialog, datetime ->
                        date = if (datetime.month < 10 && datetime.dayOfMonth < 10)
                            resources.getString(
                                R.string._0d_0m_yyyy,
                                datetime.dayOfMonth,
                                datetime.month + 1,
                                datetime.year,
                            )
                        else if (datetime.month < 10)
                            resources.getString(
                                R.string._dd_0m_yyyy,
                                datetime.dayOfMonth,
                                datetime.month + 1,
                                datetime.year,
                            )
                        else if (datetime.dayOfMonth < 10)
                            resources.getString(
                                R.string._0d_mm_yyyy,
                                datetime.dayOfMonth,
                                datetime.month + 1,
                                datetime.year,
                            )
                        else
                            resources.getString(
                                R.string.dd_mm_yyyy,
                                datetime.dayOfMonth,
                                datetime.month + 1,
                                datetime.year,
                            )
                        time = if (datetime.get(Calendar.MINUTE) < 10)
                            resources.getString(
                                R.string.h0m,
                                datetime.get(Calendar.HOUR_OF_DAY),
                                datetime.get(Calendar.MINUTE)
                            )
                        else
                            resources.getString(
                                R.string.hm,
                                datetime.get(Calendar.HOUR_OF_DAY),
                                datetime.get(Calendar.MINUTE)
                            )
                    }
                    positiveButton { dialog ->
                        val lastAppointmentId = getLastAppointmentId()
                        val appointment = Appointment(
                            id = lastAppointmentId + 1L,
                            user_id = getUserId(),
                            service_id = service.id,
                            date = date,
                            time = time,
                        )
                        upsertAppointment(appointment = appointment)
                        val notification = Notification(
                            id = getLastNotificationId() + 1L,
                            user_id = getUserId(),
                            appointment_id = lastAppointmentId + 1L,
                            shopCard_id = null
                        )
                        upsertNotification(notification = notification)
                        Toast.makeText(
                            view.context, resources.getString(
                            R.string.appointment_add,
                            service.name,
                            date,
                            time
                        ),Toast.LENGTH_LONG).show()
                    }
                }
            }
            date = ""
            time = ""
        }
    }

    private fun toAddService(view: View) {
        binding.add.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_addServiceFragment)
        }
    }
}