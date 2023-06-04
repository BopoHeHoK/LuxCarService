package com.test.luxcarservice.app.presentation.screen.root

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.test.luxcarservice.R
import com.test.luxcarservice.app.presentation.adapter.ViewPagerAdapter
import com.test.luxcarservice.app.presentation.screen.products.ProductsFragment
import com.test.luxcarservice.app.presentation.screen.profile.ProfileFragment
import com.test.luxcarservice.app.presentation.screen.services.ServicesFragment
import com.test.luxcarservice.databinding.FragmentRootBinding

class RootFragment : Fragment() {

    private lateinit var binding: FragmentRootBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        createViewPager()
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
//                        tab.setIcon(R.drawable.selector_calc)
                    }
                    1 -> {
                        tab.text = getString(R.string.products)
//                        tab.setIcon(R.drawable.selector_schedule)
                    }
                    else -> {
                        tab.text = getString(R.string.services)
//                        tab.setIcon(R.drawable.selector_home)
                    }
                }
            }.attach()
        }
    }
}