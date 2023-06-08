package com.test.luxcarservice.app.presentation.screen.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.luxcarservice.R
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.databinding.FragmentSignInBinding
import java.util.regex.Pattern
import javax.inject.Inject

class SignInFragment : Fragment() {

    @Inject
    lateinit var signInViewModelFactory: SignInViewModelFactory

    private lateinit var binding: FragmentSignInBinding
    private lateinit var signInViewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectSignInFragment(
            signInFragment = this
        )
        signInViewModel = ViewModelProvider(
            owner = this,
            factory = signInViewModelFactory
        )[SignInViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toSignUp(view)
        save(view)
    }

    private fun toSignUp(view: View) {
        binding.tvToRegistration.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }

    private fun save(view: View) {
        binding.btnLogin.setOnClickListener {
            if (checkValues()) {
                loginObserve(view)
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
            if (etPassword.text.toString().isBlank()) {
                passwordError.visibility = View.VISIBLE
                emailError.text = resources.getString(R.string.empty_field_error)
                return false
            }
        }
        return true
    }

    private fun loginObserve(view: View) {
        binding.apply {
            signInViewModel.apply {
                if (checkEmailAndPassword(
                        email = etEmail.text.toString(),
                        password = etPassword.text.toString()
                    )
                ) {
                    val user = getUser(email = etEmail.text.toString())
                    setUserId(user.id)
                    Navigation.findNavController(view)
                        .navigate(R.id.action_signInFragment_to_splashFragment)
                } else {
                    llError.visibility = View.VISIBLE
                    error.text = resources.getString(R.string.wrong_email_or_password_error)
                    save(view)
                }
            }
        }
    }
}