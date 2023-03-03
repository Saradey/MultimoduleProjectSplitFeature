package com.evgeny.goncharov.sample.multimodule.home_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgeny.goncharov.sample.multimodule.home_impl.ui.HomeContainerFragment
import com.evgeny.goncharov.sample.multimodule.home_impl.ui.HomeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object HomeScreens {

    fun startFeature() = object : FragmentScreen {
        override val screenKey: String = "HomeContainer"

        override fun createFragment(factory: FragmentFactory): Fragment {
            return HomeContainerFragment.newInstance()
        }
    }

    fun goToTheHomeFragment() = FragmentScreen {
        HomeFragment.newInstance()
    }
}