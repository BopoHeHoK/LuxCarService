package com.test.luxcarservice.app.presentation.screen.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.databinding.FragmentSignUpBinding
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

    }
}