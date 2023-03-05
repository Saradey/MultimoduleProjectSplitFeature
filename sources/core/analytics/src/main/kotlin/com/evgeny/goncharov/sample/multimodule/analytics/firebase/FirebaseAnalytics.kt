package com.evgeny.goncharov.sample.multimodule.analytics.firebase

import android.content.Context
import android.os.Bundle
import timber.log.Timber

internal class FirebaseAnalytics private constructor() {

    private val logBuilder = StringBuilder()

    fun logEvent(key: String, eventBundle: Bundle) {
        logBuilder.clear()
        Timber.tag(TAG_ANALYTICS_LOG).d(buildEvent(key, eventBundle))
    }

    private fun buildEvent(key: String, eventBundle: Bundle): String {
        return logBuilder
            .append("FirebaseAnalytics: ")
            .append(key)
            .append(" ")
            .append(eventBundle.toString())
            .toString()
    }

    companion object {

        private val firebaseAnalytics = FirebaseAnalytics()

        fun getInstance(context: Context) = firebaseAnalytics
    }
}