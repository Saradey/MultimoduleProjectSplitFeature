package com.evgeny.goncharov.sample.multimodule.analytics.firebase

import android.content.Context
import android.os.Bundle

internal class FirebaseAnalytics private constructor() {

    fun logEvent(key: String, eventBundle: Bundle) {
        //do something
    }

    companion object {

        private val firebaseAnalytics = FirebaseAnalytics()

        fun getInstance(context: Context) = firebaseAnalytics
    }
}