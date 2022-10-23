package com.evgeny.goncharov.sample.multimodule.home_impl.navigation

import com.evgeny.goncharov.sample.multimodule.home_impl.ui.HomeContainerFragment
import com.evgeny.goncharov.sample.multimodule.home_impl.ui.HomeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object HomeScreens {

    fun startFeature() = FragmentScreen {
        HomeContainerFragment.newInstance()
    }

    fun goToTheHomeFragment() = FragmentScreen {
        HomeFragment.newInstance()
    }
}