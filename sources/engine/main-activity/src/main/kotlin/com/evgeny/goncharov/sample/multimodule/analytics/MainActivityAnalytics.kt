package com.evgeny.goncharov.sample.multimodule.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.utils.TAG_SCREEN_PARAM
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

    }

    companion object {

        const val TAG_MAIN_ACTIVITY = "main_activity"

    }
}