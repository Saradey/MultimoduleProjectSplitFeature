package com.evgeny.goncharov.sample.multimodule.analytics.huawei

import android.content.Context
import android.os.Bundle
import com.evgeny.goncharov.sample.multimodule.analytics.utils.TAG_ANALYTICS_LOG
import timber.log.Timber

internal class HiAnalytics private constructor() {

    private val logBuilder = StringBuilder()

    fun logEvent(key: String, eventBundle: Bundle) {
        logBuilder.clear()
        Timber.tag(TAG_ANALYTICS_LOG).d(buildEvent(key, eventBundle))
    }

    private fun buildEvent(key: String, eventBundle: Bundle): String {
        return logBuilder
            .append("HiAnalytics: ")
            .append(key)
            .append(" ")
            .append(eventBundle.toString())
            .toString()
    }

    companion object {

        private val hiAnalytics = HiAnalytics()

        fun getInstance(context: Context) = hiAnalytics
    }
}