package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.navigation.screens

import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.SplashContainerFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object SplashScreens {

    fun startSplashFeature() = FragmentScreen {
        SplashContainerFragment.newInstance()
    }
}