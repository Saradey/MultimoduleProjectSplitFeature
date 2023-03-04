package com.evgeny.goncharov.sample.multimodule.analytics.modules

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManagerImpl
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.CoreScope
import dagger.Binds
import dagger.Module

@Module
internal interface AnalyticsModule {

    @CoreScope
    @Binds
    fun AnalyticsManagerImpl.provideAnalyticsManager(): AnalyticsManager
}