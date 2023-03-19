package com.evgeny.goncharov.sample.multimodule.profile_impl.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.utils.NAVIGATION_EVENT_KEY
import com.evgeny.goncharov.sample.multimodule.analytics.utils.TAG_SCREEN_PARAM
import javax.inject.Inject

internal class ProfileAnalytics @Inject constructor(
    private val analyticsManager: AnalyticsManager
) {

    private val params: MutableList<Pair<String, String?>> = mutableListOf<Pair<String, String?>>(
        TAG_SCREEN_PARAM to TAG_SCREEN_PROFILE
    )

    private fun prepare() {
        params.clear()
        params.add(TAG_SCREEN_PARAM to TAG_SCREEN_PROFILE)
    }

    fun goToAuth() {
        prepare()
        params.add(NAVIGATION_EVENT_GO_AUTH to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    private companion object {

        const val TAG_SCREEN_PROFILE = "profile"
        const val NAVIGATION_EVENT_GO_AUTH = "profile_go_to_authorization"
    }
}