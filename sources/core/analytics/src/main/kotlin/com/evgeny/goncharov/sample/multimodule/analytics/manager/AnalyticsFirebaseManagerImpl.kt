package com.evgeny.goncharov.sample.multimodule.analytics.manager

import android.os.Bundle
import com.evgeny.goncharov.sample.multimodule.analytics.firebase.FirebaseAnalytics

internal class AnalyticsFirebaseManagerImpl(
    private val firebaseAnalytics: FirebaseAnalytics
) : AnalyticsManager {

    override fun logEvent(eventKey: String, eventBundle: List<Pair<String, String?>>) {
        val bundle = Bundle()
        eventBundle.forEach { event ->
            bundle.putString(event.first, event.second.orEmpty())
        }
        firebaseAnalytics.logEvent(eventKey, bundle)
    }
}