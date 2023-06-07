package com.test.luxcarservice.app.presentation.screen.appointments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.databinding.FragmentAppointmentsBinding
import javax.inject.Inject

class AppointmentsFragment : Fragment() {

    @Inject
    lateinit var appointmentsViewModelFactory: AppointmentsViewModelFactory

    private lateinit var binding: FragmentAppointmentsBinding
    private lateinit var appointmentsViewModel: AppointmentsViewModel

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
        onArrowBackClick(view)
    }

    private fun onArrowBackClick(view: View) {
        binding.apply {
            arrowBack.setOnClickListener {
                Navigation.findNavController(view).popBackStack()
            }
        }
    }
}