package com.test.luxcarservice.app.presentation.screen.root

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.tabs.TabLayoutMediator
import com.test.luxcarservice.R
import com.test.luxcarservice.app.app.App
import com.test.luxcarservice.app.presentation.adapter.ViewPagerAdapter
import com.test.luxcarservice.app.presentation.screen.products.ProductsFragment
import com.test.luxcarservice.app.presentation.screen.profile.ProfileFragment
import com.test.luxcarservice.app.presentation.screen.services.ServicesFragment
import com.test.luxcarservice.databinding.FragmentRootBinding
import javax.inject.Inject

class RootFragment : Fragment() {

    @Inject
    lateinit var rootViewModelFactory: RootViewModelFactory

    private lateinit var binding: FragmentRootBinding
    private lateinit var rootViewModel: RootViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectRootFragment(
            rootFragment = this
        )
        rootViewModel = ViewModelProvider(
            owner = this,
            factory = rootViewModelFactory
        )[RootViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRootBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openSideMenu()
        onMenuItemClick(view)
        createViewPager()
    }

    private fun openSideMenu() {
        binding.apply {
            btnBurgerMenu.setOnClickListener {
                drawer.openDrawer(GravityCompat.START)
            }
        }
    }

    private fun onMenuItemClick(view: View) {
        binding.apply {
            navigationView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.your_appointments -> {
                        Navigation.findNavController(view)
                            .navigate(R.id.action_rootFragment_to_appointmentsFragment)
                    }

                    R.id.your_orders -> {
                        Navigation.findNavController(view)
                            .navigate(R.id.action_rootFragment_to_ordersFragment)
                    }

                    R.id.notifications -> {
                        Navigation.findNavController(view)
                            .navigate(R.id.action_rootFragment_to_notificationsFragment)
                    }

                    R.id.information -> {
                        Navigation.findNavController(view)
                            .navigate(R.id.action_rootFragment_to_informationFragment)
                    }

                    else -> {
                        rootViewModel.deleteUserId()
                        Navigation.findNavController(view)
                            .navigate(R.id.action_rootFragment_to_signInFragment)
                    }
                }
                true
            }
        }
    }

    private fun createViewPager() {
        val fragments: ArrayList<Fragment> = arrayListOf(
            ServicesFragment(),
            ProductsFragment(),
            ProfileFragment()
        )

        val adapter = ViewPagerAdapter(fragments, this)
        binding.apply {
            viewPager.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
                when (pos) {
                    2 -> {
                        tab.text = getString(R.string.profile)
                        tab.setIcon(R.drawable.selector_profile)
                    }

                    1 -> {
                        tab.text = getString(R.string.products)
                        tab.setIcon(R.drawable.selector_products)
                    }

                    else -> {
                        tab.text = getString(R.string.services)
                        tab.setIcon(R.drawable.selector_services)
                    }
                }
            }.attach()
        }
    }
}