package com.test.luxcarservice.app.presentation.screen.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.test.luxcarservice.R
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashFragment : Fragment() {

    @Inject
    lateinit var splashViewModelFactory: SplashViewModelFactory

    private lateinit var binding: FragmentSplashBinding
    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectSplashFragment(
            splashFragment = this
        )
        splashViewModel = ViewModelProvider(
            owner = this,
            factory = splashViewModelFactory
        )[SplashViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(3000)
            Navigation.findNavController(view)
                .navigate(R.id.action_splashFragment_to_rootFragment)
        }
    }
}