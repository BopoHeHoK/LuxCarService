package com.test.luxcarservice.app.presentation.screen.services

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.app.presentation.adapter.ServiceAdapter
import com.test.luxcarservice.databinding.FragmentServicesBinding
import javax.inject.Inject

class ServicesFragment : Fragment() {

    @Inject
    lateinit var servicesViewModelFactory: ServicesViewModelFactory

    private lateinit var binding: FragmentServicesBinding
    private lateinit var servicesViewModel: ServicesViewModel
    private lateinit var serviceAdapter: ServiceAdapter

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
    }

    private fun addOrderAdapter() {
        serviceAdapter = ServiceAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = serviceAdapter
        }
    }

    private fun observeServices() {
        addOrderAdapter()
        serviceAdapter.setServiceList(servicesViewModel.getServices())
    }
}