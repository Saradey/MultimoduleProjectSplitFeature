package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.navigation.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.ui.SplashContainerFragment
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.ui.SplashFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object SplashScreens {

    fun startSplashFeature() = object : FragmentScreen {
        override val screenKey: String = "SplashContainer"

        override fun createFragment(factory: FragmentFactory): Fragment {
            return SplashContainerFragment.newInstance()
        }
    }

    fun goToTheSplashFragment() = FragmentScreen {
        SplashFragment.newInstance()
    }
}