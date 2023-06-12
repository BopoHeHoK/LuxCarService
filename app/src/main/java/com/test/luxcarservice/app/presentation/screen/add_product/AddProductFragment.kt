package com.test.luxcarservice.app.presentation.screen.add_product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.luxcarservice.R
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.databinding.FragmentAddProductBinding
import javax.inject.Inject

class AddProductFragment : Fragment() {

    @Inject
    lateinit var addProductViewModelFactory: AddProductViewModelFactory

    private lateinit var binding: FragmentAddProductBinding
    private lateinit var addProductViewModel: AddProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectAddProductFragment(
            addProductFragment = this
        )
        addProductViewModel = ViewModelProvider(
            owner = this,
            factory = addProductViewModelFactory
        )[AddProductViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddProductBinding.inflate(layoutInflater)
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