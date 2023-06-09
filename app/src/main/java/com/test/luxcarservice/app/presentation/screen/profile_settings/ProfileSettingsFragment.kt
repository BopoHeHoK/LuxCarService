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
import com.test.luxcarservice.domain.model.User
import java.util.regex.Pattern
import javax.inject.Inject

class ProfileSettingsFragment : Fragment() {

    @Inject
    lateinit var profileSettingsViewModelFactory: ProfileSettingsViewModelFactory

    private lateinit var binding: FragmentProfileSettingsBinding
    private lateinit var profileSettingsViewModel: ProfileSettingsViewModel

    private var email = ""
    private var password = ""
    private var phoneNumber = ""
    private var firstName = ""
    private var lastName = ""
    private var roleId = 1L

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
        observeUser()
        saveChanges(view)
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

    private fun observeUser() {
        binding.apply {
            profileSettingsViewModel.apply {
                val user = getUser(getUserId())
                roleId = user.role_id
                user.first_name?.let {
                    etFirstName.hint = it
                    firstName = it
                }
                user.last_name?.let {
                    etLastName.hint = it
                    lastName = it
                }
                user.email?.let {
                    etEmail.hint = it
                    email = it
                }
                user.password?.let {
                    password = it
                }
                user.phone_number?.let {
                    etPhoneNumber.hint = it
                    phoneNumber = it
                }
            }
        }
    }

    private fun isValidString(str: String): Boolean {
        val EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
        return EMAIL_ADDRESS_PATTERN.matcher(str).matches()
    }

    private fun checkFieldValues() {
        binding.apply {
            if (etEmail.text.toString().isNotBlank()) {
                email = etEmail.text.toString()
            }
            if (etPhoneNumber.text.toString().isNotBlank()) {
                phoneNumber = etPhoneNumber.text.toString()
            }
            if (etFirstName.text.toString().isNotBlank()) {
                firstName = etFirstName.text.toString()
            }
            if (etLastName.text.toString().isNotBlank()) {
                lastName = etLastName.text.toString()
            }
        }
    }

    private fun saveChanges(view: View) {
        binding.apply {
            save.setOnClickListener {
                checkFieldValues()
                emailError.visibility = View.GONE
                profileSettingsViewModel.apply {
                    if (etEmail.text.toString()
                            .isNotBlank() && !isValidString(etEmail.text.toString())
                    ) {
                        emailError.visibility = View.VISIBLE
                    } else {
                        val user = User(
                            id = getUserId(),
                            email = email,
                            password = password,
                            phone_number = phoneNumber,
                            first_name = firstName,
                            last_name = lastName,
                            role_id = roleId,
                        )
                        upsertUser(user = user)
                        Navigation.findNavController(view).popBackStack()
                    }
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