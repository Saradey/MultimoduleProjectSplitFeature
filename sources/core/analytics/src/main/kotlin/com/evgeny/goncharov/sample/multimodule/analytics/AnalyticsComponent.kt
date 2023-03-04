package com.evgeny.goncharov.sample.multimodule.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.analytics.modules.AnalyticsModule
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.CoreScope
import dagger.Component

@CoreScope
@Component(modules = [AnalyticsModule::class])
internal interface AnalyticsComponent : AnalyticsDependencyApi