package com.test.luxcarservice.app.presentation.screen.orders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.app.presentation.adapter.OrderAdapter
import com.test.luxcarservice.databinding.FragmentOrdersBinding
import javax.inject.Inject

class OrdersFragment : Fragment() {

    @Inject
    lateinit var ordersViewModelFactory: OrdersViewModelFactory

    private lateinit var binding: FragmentOrdersBinding
    private lateinit var ordersViewModel: OrdersViewModel
    private lateinit var orderAdapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectOrdersFragment(
            ordersFragment = this
        )
        ordersViewModel = ViewModelProvider(
            owner = this,
            factory = ordersViewModelFactory
        )[OrdersViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrdersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeOrders()
        onArrowBackClick(view)
    }

    private fun addOrderAdapter() {
        orderAdapter = OrderAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = orderAdapter
        }
    }

    private fun observeOrders() {
        addOrderAdapter()
        orderAdapter.setOrderList(ordersViewModel.getOrders())
    }

    private fun onArrowBackClick(view: View) {
        binding.apply {
            arrowBack.setOnClickListener {
                Navigation.findNavController(view).popBackStack()
            }
        }
    }
}