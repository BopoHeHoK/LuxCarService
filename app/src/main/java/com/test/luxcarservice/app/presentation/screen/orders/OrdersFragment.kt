package com.test.luxcarservice.app.presentation.screen.orders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.databinding.FragmentOrdersBinding
import javax.inject.Inject

class OrdersFragment : Fragment() {

    @Inject
    lateinit var ordersViewModelFactory: OrdersViewModelFactory

    private lateinit var binding: FragmentOrdersBinding
    private lateinit var ordersViewModel: OrdersViewModel

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