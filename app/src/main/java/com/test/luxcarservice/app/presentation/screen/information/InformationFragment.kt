package com.test.luxcarservice.app.presentation.screen.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.databinding.FragmentInformationBinding
import javax.inject.Inject

class InformationFragment : Fragment() {

    @Inject
    lateinit var informationViewModelFactory: InformationViewModelFactory

    private lateinit var binding: FragmentInformationBinding
    private lateinit var informationViewModel: InformationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectInformationFragment(
            informationFragment = this
        )
        informationViewModel = ViewModelProvider(
            owner = this,
            factory = informationViewModelFactory
        )[InformationViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInformationBinding.inflate(layoutInflater)
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