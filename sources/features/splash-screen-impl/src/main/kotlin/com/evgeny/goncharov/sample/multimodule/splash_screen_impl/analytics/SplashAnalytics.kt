package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.utils.TAG_SCREEN_PARAM
import com.evgeny.goncharov.sample.multimodule.analytics.utils.NAVIGATION_EVENT_KEY
import javax.inject.Inject

internal class SplashAnalytics @Inject constructor(
    private val analyticsManager: AnalyticsManager
) {

    private val params: MutableList<Pair<String, String?>> = mutableListOf<Pair<String, String?>>(
        TAG_SCREEN_PARAM to TAG_SPLASH_PARAM
    )

    private fun prepare() {
        params.clear()
        params.add(TAG_SCREEN_PARAM to TAG_SPLASH_PARAM)
    }

    fun goToTheBottomMainMenu() {
        prepare()
        params.add(UI_EVENT_GO_BOTTOM_MENU to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    private companion object {
        const val TAG_SPLASH_PARAM = "splash"
        const val UI_EVENT_GO_BOTTOM_MENU = "splash_go_to_bottom_menu"
    }
}