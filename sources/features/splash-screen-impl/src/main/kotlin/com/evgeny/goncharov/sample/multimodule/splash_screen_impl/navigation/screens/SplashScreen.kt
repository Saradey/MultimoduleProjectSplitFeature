package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.navigation.screens

import androidx.fragment.app.FragmentFactory
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.SplashContainerFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object SplashScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory) =
        SplashContainerFragment.newInstance()
}