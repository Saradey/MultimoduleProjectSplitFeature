package com.evgeny.goncharov.sample.multimodule.analytics.holder

import com.evgeny.goncharov.sample.multimodule.analytics.DaggerCoreAnalyticsComponent
import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.BaseHolder

public class AnalyticsHolder(
    featureContainer: FeatureContainerManager
) : BaseHolder<AnalyticsDependencyApi>(featureContainer) {

    override fun buildComponent(): AnalyticsDependencyApi {
        return DaggerCoreAnalyticsComponent.create()
    }
}