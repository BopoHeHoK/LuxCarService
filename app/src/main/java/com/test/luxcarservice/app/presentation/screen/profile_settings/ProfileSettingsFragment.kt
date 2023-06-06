package com.test.luxcarservice.app.presentation.screen.profile_settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.databinding.FragmentProfileSettingsBinding
import javax.inject.Inject

class ProfileSettingsFragment : Fragment() {

    @Inject
    lateinit var profileSettingsViewModelFactory: ProfileSettingsViewModelFactory

    private lateinit var binding: FragmentProfileSettingsBinding
    private lateinit var profileSettingsViewModel: ProfileSettingsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectProfileSettingsFragment(
            profileSettingsFragment = this
        )
        profileSettingsViewModel = ViewModelProvider(
            owner = this,
            factory = profileSettingsViewModelFactory
        )[ProfileSettingsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileSettingsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}