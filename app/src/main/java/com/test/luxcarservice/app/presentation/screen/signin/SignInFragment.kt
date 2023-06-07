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

    }
}