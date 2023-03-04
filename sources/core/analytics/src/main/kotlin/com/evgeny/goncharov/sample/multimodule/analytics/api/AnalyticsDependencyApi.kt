package com.evgeny.goncharov.sample.multimodule.analytics.api

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager

public interface AnalyticsDependencyApi {

    public fun provideAnalyticsManager(): AnalyticsManager
}