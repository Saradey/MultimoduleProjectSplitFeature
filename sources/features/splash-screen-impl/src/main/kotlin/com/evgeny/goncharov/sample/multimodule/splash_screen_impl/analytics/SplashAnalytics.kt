package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.utils.TAG_SCREEN_PARAM
import com.evgeny.goncharov.sample.multimodule.analytics.utils.UI_EVENT_KEY_NAVIGATION
import javax.inject.Inject

internal class SplashAnalytics @Inject constructor(
    private val analyticsDependencyApi: AnalyticsManager
) {

    private val params = mutableListOf<Pair<String, String?>>(
        TAG_SCREEN_PARAM to TAG_SPLASH_SCREEN_PARAM
    )

    fun goToTheBottomMainMenu() {
        params.add(UI_EVENT_NAVIGATION_SPLASH_TO_BOTTOM_MENU to null)
        analyticsDependencyApi.logEvent(UI_EVENT_KEY_NAVIGATION, params)
    }

    private companion object {
        private const val TAG_SPLASH_SCREEN_PARAM = "splash_screen"
        private const val UI_EVENT_NAVIGATION_SPLASH_TO_BOTTOM_MENU =
            "splash_screen_go_to_bottom_menu_screen"
    }
}