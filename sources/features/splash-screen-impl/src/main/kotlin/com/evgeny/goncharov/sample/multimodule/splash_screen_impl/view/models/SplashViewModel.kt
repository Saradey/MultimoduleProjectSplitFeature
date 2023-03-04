package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.view.models

import androidx.lifecycle.ViewModel
import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuLauncher
import javax.inject.Inject

internal class SplashViewModel @Inject constructor(
    private val mainLauncher: BottomMenuLauncher,
    private val analyticsDependencyApi: AnalyticsDependencyApi
) : ViewModel() {

    fun launchToBottomMenu() {
        mainLauncher.launch()
    }

    companion object {

        private const val DELAY = 1500L
    }
}