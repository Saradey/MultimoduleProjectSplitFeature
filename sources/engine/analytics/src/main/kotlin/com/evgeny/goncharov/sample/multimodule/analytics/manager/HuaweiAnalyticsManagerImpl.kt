package com.evgeny.goncharov.sample.multimodule.analytics.manager

import android.os.Bundle
import com.evgeny.goncharov.sample.multimodule.analytics.huawei.HiAnalytics

internal class HuaweiAnalyticsManagerImpl(
    private val hiAnalytics: HiAnalytics
) : AnalyticsManager {

    override fun logEvent(eventKey: String, eventBundle: List<Pair<String, String?>>) {
        val bundle = Bundle()
        eventBundle.forEach { event ->
            bundle.putString(event.first, event.second.orEmpty())
        }
        hiAnalytics.logEvent(eventKey, bundle)
    }
}