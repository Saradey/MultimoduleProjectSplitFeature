package com.evgeny.goncharov.sample.multimodule.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.analytics.modules.AnalyticsBindsModule
import com.evgeny.goncharov.sample.multimodule.analytics.modules.AnalyticsProvidesModule
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.CoreScope
import dagger.Component

@CoreScope
@Component(modules = [
    AnalyticsBindsModule::class,
    AnalyticsProvidesModule::class
])
internal interface AnalyticsComponent : AnalyticsDependencyApi