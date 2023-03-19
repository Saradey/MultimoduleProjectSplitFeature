package com.evgeny.goncharov.sample.multimodule.profile_impl.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import javax.inject.Inject

internal class ProfileAnalytics @Inject constructor(
    private val analyticsManager: AnalyticsManager
) {


    private companion object {
        
    }
}