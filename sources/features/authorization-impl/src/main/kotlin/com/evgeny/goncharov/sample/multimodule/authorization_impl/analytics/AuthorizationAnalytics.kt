package com.evgeny.goncharov.sample.multimodule.authorization_impl.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.utils.NAVIGATION_EVENT_KEY
import com.evgeny.goncharov.sample.multimodule.analytics.utils.TAG_SCREEN_PARAM
import javax.inject.Inject

internal class AuthorizationAnalytics @Inject constructor(
    private val analyticsManager: AnalyticsManager
) {
    private val params: MutableList<Pair<String, String?>> = mutableListOf<Pair<String, String?>>(
        TAG_SCREEN_PARAM to TAG_AUTH_PARAM
    )

    private fun prepare() {
        params.clear()
        params.add(TAG_SCREEN_PARAM to TAG_AUTH_PARAM)
    }

    fun goToProfile() {
        prepare()
        params.add(NAVIGATION_EVENT_GO_PROFILE to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    private companion object {

        const val TAG_AUTH_PARAM = "authorization"
        const val NAVIGATION_EVENT_GO_PROFILE = "authorization_go_to_profile"
    }
}