package com.evgeny.goncharov.sample.multimodule.authorization_impl.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import javax.inject.Inject

internal class AuthorizationAnalytics @Inject constructor(
    private val analyticsManager: AnalyticsManager
) {
}