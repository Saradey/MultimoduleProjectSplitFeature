package com.evgeny.goncharov.sample.multimodule.analytics.holder

import android.content.Context
import com.evgeny.goncharov.sample.multimodule.analytics.DaggerAnalyticsComponent
import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.BaseHolder

public class AnalyticsHolder(
    featureContainer: FeatureContainerManager,
    private val appContext: Context,
    private val isHuaweiAnalytics: Boolean
) : BaseHolder<AnalyticsDependencyApi>(featureContainer) {

    override fun buildComponent(): AnalyticsDependencyApi {
        return DaggerAnalyticsComponent.factory().create(
            appContext, isHuaweiAnalytics
        )
    }
}