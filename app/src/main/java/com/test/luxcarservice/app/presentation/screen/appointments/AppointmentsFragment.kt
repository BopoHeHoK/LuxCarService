package com.test.luxcarservice.app.presentation.screen.appointments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.app.presentation.adapter.AppointmentAdapter
import com.test.luxcarservice.databinding.FragmentAppointmentsBinding
import javax.inject.Inject

class AppointmentsFragment : Fragment() {

    @Inject
    lateinit var appointmentsViewModelFactory: AppointmentsViewModelFactory

    private lateinit var binding: FragmentAppointmentsBinding
    private lateinit var appointmentsViewModel: AppointmentsViewModel
    private lateinit var appointmentAdapter: AppointmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectAppointmentsFragment(
            appointmentsFragment = this
        )
        appointmentsViewModel = ViewModelProvider(
            owner = this,
            factory = appointmentsViewModelFactory
        )[AppointmentsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAppointmentsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeAppointments()
        onArrowBackClick(view)
    }

    private fun addAppointmentAdapter() {
        appointmentAdapter = AppointmentAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = appointmentAdapter
        }
    }

    private fun observeAppointments() {
        addAppointmentAdapter()
        appointmentAdapter.apply {
            appointmentsViewModel.apply {
                if (getRoles()[getRoles().indexOf(getRoles().firstOrNull {
                        it.id == getUser(getUserId()).role_id
                    })].role == "STAFF") {
                    setAppointmentList(getAppointments())
                } else {
                    setAppointmentList(getUserAppointments(getUserId()))
                }
                setServiceList(getServices())
                setUserList(getUsers())
            }
        }
    }

    private fun onArrowBackClick(view: View) {
        binding.apply {
            arrowBack.setOnClickListener {
                Navigation.findNavController(view).popBackStack()
            }
        }
    }
}