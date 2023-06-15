package com.test.luxcarservice.app.presentation.screen.notifications

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.app.presentation.adapter.NotificationAdapter
import com.test.luxcarservice.databinding.FragmentNotificationsBinding
import javax.inject.Inject

class NotificationsFragment : Fragment() {

    @Inject
    lateinit var notificationsViewModelFactory: NotificationsViewModelFactory

    private lateinit var binding: FragmentNotificationsBinding
    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var notificationAdapter: NotificationAdapter

    private var userRole = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectNotificationsFragment(
            notificationsFragment = this
        )
        notificationsViewModel = ViewModelProvider(
            owner = this,
            factory = notificationsViewModelFactory
        )[NotificationsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeNotifications()
        onArrowBackClick(view)
    }

    private fun addNotificationAdapter() {
        notificationAdapter = NotificationAdapter(userRole)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = notificationAdapter
        }
    }

    private fun observeNotifications() {
        notificationsViewModel.apply {
            userRole = getRoles()[getRoles().indexOf(getRoles().firstOrNull {
                it.id == getUser(getUserId()).role_id
            })].role.toString()
            addNotificationAdapter()
            notificationAdapter.apply {
                if (userRole == "STAFF") {
                    setNotificationList(getNotifications())
                } else {
                    setNotificationList(getNotificationsByUserId(userId = getUserId()))
                }
                setAppointmentList(getAppointments())
                setOrderList(getOrders())
                setServiceList(getServices())
                setProductList(getProducts())
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