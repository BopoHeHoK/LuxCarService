package com.test.luxcarservice.app.presentation.screen.add_service

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.databinding.FragmentAddServiceBinding
import com.test.luxcarservice.domain.model.Service
import javax.inject.Inject

class AddServiceFragment : Fragment() {

    @Inject
    lateinit var addServiceViewModelFactory: AddServiceViewModelFactory

    private lateinit var binding: FragmentAddServiceBinding
    private lateinit var addServiceViewModel: AddServiceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectAddServiceFragment(
            addServiceFragment = this
        )
        addServiceViewModel = ViewModelProvider(
            owner = this,
            factory = addServiceViewModelFactory
        )[AddServiceViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddServiceBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onSaveButtonClick(view)
        onArrowBackClick(view)
    }

    private fun onSaveButtonClick(view: View) {
        binding.apply {
            save.setOnClickListener {
                addServiceViewModel.apply {
                    val service = Service(
                        id = getLastServiceId() + 1L,
                        name = etName.text.toString(),
                        description = etDecription.text.toString(),
                        price = etPrice.text.toString().toFloat(),
                    )
                    upsertService(service = service)
                    Navigation.findNavController(view).popBackStack()
                }
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