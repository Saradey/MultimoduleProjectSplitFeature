package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.view.models

import androidx.lifecycle.ViewModel
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuLauncher
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.analytics.SplashAnalytics
import javax.inject.Inject

internal class SplashViewModel @Inject constructor(
    private val mainLauncher: BottomMenuLauncher,
    private val analytics: SplashAnalytics
) : ViewModel() {

    fun launchToBottomMenu() {
        mainLauncher.launch()
        analytics.goToTheBottomMainMenu()
    }

    companion object {

        private const val DELAY = 1500L
    }
}