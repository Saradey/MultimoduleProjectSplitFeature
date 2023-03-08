package com.evgeny.goncharov.sample.multimodule.view.models

import androidx.lifecycle.ViewModel
import com.evgeny.goncharov.sample.multimodule.analytics.MainActivityAnalytics
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashLauncher
import javax.inject.Inject

internal class MainActivityViewModel @Inject constructor(
    private val splashLauncher: SplashLauncher,
    private val analytics: MainActivityAnalytics
) : ViewModel() {

    fun startSplash() {
        splashLauncher.launch()
        analytics.startSplash()
    }
}