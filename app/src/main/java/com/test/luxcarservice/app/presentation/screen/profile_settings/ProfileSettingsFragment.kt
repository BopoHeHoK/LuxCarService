package com.test.luxcarservice.app.presentation.screen.profile_settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
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
        openChangePassword()
        closeChangePassword()
        onArrowBackClick(view)
    }

    private fun openChangePassword() {
        binding.apply {
            changePassword.setOnClickListener {
                changePassword.visibility = View.GONE
                clChangePassword.visibility = View.VISIBLE
            }
        }
    }

    private fun closeChangePassword() {
        binding.apply {
            close.setOnClickListener {
                changePassword.visibility = View.VISIBLE
                clChangePassword.visibility = View.GONE
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