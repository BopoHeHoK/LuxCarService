package com.test.luxcarservice.app.presentation.screen.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.luxcarservice.R
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.databinding.FragmentProfileBinding
import javax.inject.Inject

class ProfileFragment : Fragment() {

    @Inject
    lateinit var profileViewModelFactory: ProfileViewModelFactory

    private lateinit var binding: FragmentProfileBinding
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectProfileFragment(
            profileFragment = this
        )
        profileViewModel = ViewModelProvider(
            owner = this,
            factory = profileViewModelFactory
        )[ProfileViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toProfileSettings(view)
        toAppointments(view)
        toOrders(view)
        toNotifications(view)
        logout(view)
    }

    private fun toProfileSettings(view: View) {
        binding.linear1.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_profileSettingsFragment)
        }
    }

    private fun toAppointments(view: View) {
        binding.linear2.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_appointmentsFragment)
        }
    }

    private fun toOrders(view: View) {
        binding.linear3.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_ordersFragment)
        }
    }

    private fun toNotifications(view: View) {
        binding.linear4.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_notificationsFragment)
        }
    }

    private fun logout(view: View) {
        binding.linear5.setOnClickListener {
            profileViewModel.deleteUserId()
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_signInFragment)
        }
    }
}