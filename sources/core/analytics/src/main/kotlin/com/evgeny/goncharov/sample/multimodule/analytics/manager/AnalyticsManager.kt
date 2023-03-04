package com.evgeny.goncharov.sample.multimodule.analytics.manager

public interface AnalyticsManager {

    public fun logEvent(eventKey: String, eventBundle: List<Pair<String, String?>>)
}