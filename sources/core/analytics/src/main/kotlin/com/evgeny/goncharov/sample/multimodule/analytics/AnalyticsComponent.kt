package com.evgeny.goncharov.sample.multimodule.analytics

import android.content.Context
import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.analytics.modules.ProvidesManagerAnalyticsModule
import com.evgeny.goncharov.sample.multimodule.analytics.modules.ProvidesAnalyticsModule
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.CoreScope
import dagger.BindsInstance
import dagger.Component

@CoreScope
@Component(
    modules = [
        ProvidesManagerAnalyticsModule::class,
        ProvidesAnalyticsModule::class
    ]
)
internal interface AnalyticsComponent : AnalyticsDependencyApi {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context,
            @BindsInstance isHuaweiAnalytics: Boolean
        ): AnalyticsComponent
    }
}