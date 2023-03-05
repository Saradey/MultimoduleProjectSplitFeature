package com.evgeny.goncharov.sample.multimodule.analytics.huawei

import android.content.Context
import android.os.Bundle
import timber.log.Timber

internal class HiAnalytics private constructor() {

    private val logBuilder = StringBuilder()

    fun logEvent(key: String, eventBundle: Bundle) {
        logBuilder.clear()
        Timber.tag(TAG).d(buildEvent(key, eventBundle))
    }

    private fun buildEvent(key: String, eventBundle: Bundle): String {
        return logBuilder.append(key)
            .append(" ")
            .append(eventBundle.toString())
            .toString()
    }

    companion object {

        private val hiAnalytics = HiAnalytics()

        fun getInstance(context: Context) = hiAnalytics

        private const val TAG = "HiAnalytics"
    }
}