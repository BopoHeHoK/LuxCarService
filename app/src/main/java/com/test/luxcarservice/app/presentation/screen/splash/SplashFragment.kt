package com.test.luxcarservice.app.presentation.screen.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.test.luxcarservice.R
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.databinding.FragmentSplashBinding
import com.test.luxcarservice.domain.model.Role
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
        addAnim()
        lifecycleScope.launch {
            setRoles()
            splashViewModel.apply {
                if (getUserId() == 0L) {
                    delay(1000)
                    Navigation.findNavController(view)
                        .navigate(R.id.action_splashFragment_to_signInFragment)
                } else {
                    delay(3000)
                    Navigation.findNavController(view)
                        .navigate(R.id.action_splashFragment_to_rootFragment)
                }
            }
        }
    }

    private fun setRoles() {
        val roles = listOf(Role(1, "USER"), Role(2, "STAFF"))
        for (role in roles)
            splashViewModel.upsertRole(role)
    }

    private fun addAnim() {
        val rotate = AnimationUtils.loadAnimation(context, R.anim.loading_rotate)
        binding.imgLoading.animation = rotate
    }
}