package com.evgeny.goncharov.sample.multimodule.analytics.manager

import android.os.Bundle

public interface AnalyticsManager {

    public fun logEvent(key: String, eventBundle: Bundle)
}