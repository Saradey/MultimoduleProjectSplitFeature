package com.evgeny.goncharov.sample.multimodule.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.utils.SYSTEM_EVENTS_KEY
import com.evgeny.goncharov.sample.multimodule.analytics.utils.TAG_SCREEN_PARAM
import com.evgeny.goncharov.sample.multimodule.analytics.utils.UI_EVENT_KEY_NAVIGATION
import javax.inject.Inject

internal class MainActivityAnalytics @Inject constructor(
    private val analyticsManager: AnalyticsManager
) {

    private val params: MutableList<Pair<String, String?>> = mutableListOf<Pair<String, String?>>(
        TAG_SCREEN_PARAM to TAG_MAIN_ACTIVITY
    )

    private fun prepare() {
        params.clear()
        params.add(TAG_SCREEN_PARAM to TAG_MAIN_ACTIVITY)
    }

    fun startSplash() {
        prepare()
        params.add(UI_EVENT_START_SPLASH to null)
        analyticsManager.logEvent(UI_EVENT_KEY_NAVIGATION, params)
    }

    fun finisApplication() {
        prepare()
        params.add(UI_EVENT_FINISH_APP to null)
        analyticsManager.logEvent(SYSTEM_EVENTS_KEY, params)
    }

    private companion object {

        const val TAG_MAIN_ACTIVITY = "main_activity"
        const val UI_EVENT_START_SPLASH = "main_activity_start_splash"
        const val UI_EVENT_FINISH_APP = "finish_application"
    }
}