package com.evgeny.goncharov.sample.multimodule.profile_impl.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import javax.inject.Inject

internal class ProfileAnalytics @Inject constructor(
    private val analyticsManager: AnalyticsManager
) {


    private companion object {

        const val TAG_PROFILE_PARAM = "profile"
        const val NAVIGATION_EVENT_GO_AUTH = "profile_go_to_authorization"
    }
}