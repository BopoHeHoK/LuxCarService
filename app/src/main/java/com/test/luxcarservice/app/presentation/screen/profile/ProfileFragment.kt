package com.test.luxcarservice.app.presentation.screen.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.databinding.FragmentProfileBinding
import javax.inject.Inject

class ProfileFragment : Fragment() {

    @Inject
    lateinit var profileViewModelFactory: ProfileViewModelFactory

    private lateinit var binding: FragmentProfileBinding
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectProfileFragment(
            profileFragment = this
        )
        profileViewModel = ViewModelProvider(
            owner = this,
            factory = profileViewModelFactory
        )[ProfileViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}