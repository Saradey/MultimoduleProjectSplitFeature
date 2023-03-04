package com.evgeny.goncharov.sample.multimodule.analytics.firebase

import android.content.Context
import android.os.Bundle
import timber.log.Timber

internal class FirebaseAnalytics private constructor() {

    fun logEvent(key: String, eventBundle: Bundle) {
        Timber.tag(TAG).d(eventBundle.toString())
    }

    companion object {

        private val firebaseAnalytics = FirebaseAnalytics()

        fun getInstance(context: Context) = firebaseAnalytics

        private const val TAG = "FirebaseAnalytics"
    }
}