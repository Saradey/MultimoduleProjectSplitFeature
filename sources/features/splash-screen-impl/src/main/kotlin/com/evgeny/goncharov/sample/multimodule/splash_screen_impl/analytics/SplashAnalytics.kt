package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.utils.TAG_SCREEN_PARAM
import javax.inject.Inject

internal class SplashAnalytics @Inject constructor(
    private val analyticsDependencyApi: AnalyticsManager
) {

    private val params = mutableListOf<Pair<String, String>>(
        TAG_SCREEN_PARAM to TAG_SPLASH_SCREEN_PARAM
    )

    fun goToTheBottomMainMenu() {
        analyticsDependencyApi.logEvent()
    }

    private companion object {
        private const val TAG_SPLASH_SCREEN_PARAM = "splash_screen"
    }
}