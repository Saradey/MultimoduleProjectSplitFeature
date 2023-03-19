package com.evgeny.goncharov.sample.multimodule.user.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.utils.NETWORK_EVENT_KEY
import javax.inject.Inject

internal class UserAnalytics @Inject constructor(
    private val analyticsManager: AnalyticsManager
) {

    fun signIn() {
        //TODO will add id user
        analyticsManager.logEvent(NETWORK_EVENT_KEY, listOf(NETWORK_EVENT_SIGN_IN to null))
    }

    fun signOut() {
        //TODO will add id user
        analyticsManager.logEvent(NETWORK_EVENT_KEY, listOf(NETWORK_EVENT_SIGN_OUT to null))
    }

    private companion object {
        const val NETWORK_EVENT_SIGN_IN = "sign_in"
        const val NETWORK_EVENT_SIGN_OUT = "sign_out"
    }
}