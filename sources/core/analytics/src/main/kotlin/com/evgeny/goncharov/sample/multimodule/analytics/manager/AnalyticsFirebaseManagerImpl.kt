package com.evgeny.goncharov.sample.multimodule.analytics.manager

import android.os.Bundle
import com.evgeny.goncharov.sample.multimodule.analytics.firebase.FirebaseAnalytics
import javax.inject.Inject

internal class AnalyticsFirebaseManagerImpl @Inject constructor(
    private val firebaseAnalytics: FirebaseAnalytics
) : AnalyticsManager {

    override fun logEvent(key: String, eventBundle: List<Pair<String, String>>) {
        val bundle = Bundle()
        eventBundle.forEach { event ->
            bundle.putString(event.first, event.second)
        }
        firebaseAnalytics.logEvent(key, bundle)
    }
}