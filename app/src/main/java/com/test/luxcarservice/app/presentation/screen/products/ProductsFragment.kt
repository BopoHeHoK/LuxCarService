package com.test.luxcarservice.app.presentation.screen.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.databinding.FragmentProductsBinding
import javax.inject.Inject

class ProductsFragment : Fragment() {

    @Inject
    lateinit var productsViewModelFactory: ProductsViewModelFactory

    private lateinit var binding: FragmentProductsBinding
    private lateinit var productsViewModel: ProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectProductsFragment(
            productsFragment = this
        )
        productsViewModel = ViewModelProvider(
            owner = this,
            factory = productsViewModelFactory
        )[ProductsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}