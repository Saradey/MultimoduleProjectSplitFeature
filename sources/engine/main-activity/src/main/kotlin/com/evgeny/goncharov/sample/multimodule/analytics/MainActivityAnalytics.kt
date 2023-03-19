package com.evgeny.goncharov.sample.multimodule.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.utils.SYSTEM_EVENT_KEY
import com.evgeny.goncharov.sample.multimodule.analytics.utils.TAG_SCREEN_PARAM
import com.evgeny.goncharov.sample.multimodule.analytics.utils.NAVIGATION_EVENT_KEY
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
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    fun startApplication() {
        prepare()
        params.add(UI_EVENT_START_APP to null)
        analyticsManager.logEvent(SYSTEM_EVENT_KEY, params)
    }

    fun finisApplication() {
        prepare()
        params.add(UI_EVENT_FINISH_APP to null)
        analyticsManager.logEvent(SYSTEM_EVENT_KEY, params)
    }

    private companion object {

        const val TAG_MAIN_ACTIVITY = "main_activity"
        const val UI_EVENT_START_SPLASH = "main_activity_start_splash"
        const val UI_EVENT_FINISH_APP = "finish_application"
        const val UI_EVENT_START_APP = "start_application"
    }
}