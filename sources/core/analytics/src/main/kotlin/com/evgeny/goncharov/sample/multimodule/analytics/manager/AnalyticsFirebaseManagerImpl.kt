package com.evgeny.goncharov.sample.multimodule.analytics.manager

import android.os.Bundle
import com.evgeny.goncharov.sample.multimodule.analytics.firebase.FirebaseAnalytics
import javax.inject.Inject

internal class AnalyticsFirebaseManagerImpl @Inject constructor(
    private val firebaseAnalytics: FirebaseAnalytics
) : AnalyticsManager {

    override fun logEvent(key: String, eventBundle: Bundle) {
        firebaseAnalytics.logEvent(key, eventBundle)
    }
}