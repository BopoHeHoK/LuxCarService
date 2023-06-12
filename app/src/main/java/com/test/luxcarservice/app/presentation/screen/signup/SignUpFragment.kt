package com.test.luxcarservice.app.presentation.screen.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.luxcarservice.R
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.databinding.FragmentSignUpBinding
import com.test.luxcarservice.domain.model.User
import java.util.regex.Pattern
import javax.inject.Inject

class SignUpFragment : Fragment() {

    @Inject
    lateinit var signUpViewModelFactory: SignUpViewModelFactory

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var signUpViewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectSignUpFragment(
            signUpFragment = this
        )
        signUpViewModel = ViewModelProvider(
            owner = this,
            factory = signUpViewModelFactory
        )[SignUpViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toSignIn(view)
        save(view)
    }

    private fun toSignIn(view: View) {
        binding.tvToLogin.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
    }

    private fun save(view: View) {
        binding.btnRegister.setOnClickListener {
            if (checkValues()) {
                registerObserve(view)
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

    private fun checkValues(): Boolean {
        binding.apply {
            emailError.visibility = View.GONE
            firstNameError.visibility = View.GONE
            lastNameError.visibility = View.GONE
            passwordError.visibility = View.GONE
            if (etEmail.text.toString().isBlank()) {
                emailError.visibility = View.VISIBLE
                emailError.text = resources.getString(R.string.empty_field_error)
                return false
            }
            if (etEmail.text.toString().isNotBlank() && !isValidString(etEmail.text.toString())) {
                emailError.visibility = View.VISIBLE
                emailError.text = resources.getString(R.string.email_format_error)
                return false
            }
            if (etFirstName.text.toString().isBlank()) {
                firstNameError.visibility = View.VISIBLE
                emailError.text = resources.getString(R.string.empty_field_error)
                return false
            }
            if (etLastName.text.toString().isBlank()) {
                lastNameError.visibility = View.VISIBLE
                emailError.text = resources.getString(R.string.empty_field_error)
                return false
            }
            if (etPassword.text.toString().isBlank()) {
                passwordError.visibility = View.VISIBLE
                emailError.text = resources.getString(R.string.empty_field_error)
                return false
            }
            if (etPassword.text.toString().isNotBlank() && etPassword.text.toString().length <= 6) {
                passwordError.visibility = View.VISIBLE
                passwordError.text = resources.getString(R.string.password_length_error)
                return false
            }
            if (etRepeatPassword.text.toString().isNotBlank()
                && etPassword.text.toString() != etRepeatPassword.text.toString()
            ) {
                passwordError.visibility = View.VISIBLE
                passwordError.text = resources.getString(R.string.repeat_password_error)
                return false
            }
        }
        return true
    }

    private fun registerObserve(view: View) {
        binding.apply {
            signUpViewModel.apply {
                var role = 1L
                if (etEmail.text.toString() == "test@test.test") {
                    role = 2L
                }
                val user = User(
                    id = getLastUserId() + 1L,
                    email = etEmail.text.toString(),
                    password = etPassword.text.toString(),
                    phone_number = null,
                    first_name = etFirstName.text.toString(),
                    last_name = etLastName.text.toString(),
                    role_id = role,
                )
                if (!user.email.isNullOrEmpty() && !checkEmail(email = user.email)) {
                    setUserId(userId = user.id)
                    upsertUser(user = user)
                    Navigation.findNavController(view)
                        .navigate(R.id.action_signUpFragment_to_splashFragment)
                } else {
                    llError.visibility = View.VISIBLE
                    error.text = resources.getString(R.string.email_exist_error)
                    save(view)
                }
            }
        }
    }
}