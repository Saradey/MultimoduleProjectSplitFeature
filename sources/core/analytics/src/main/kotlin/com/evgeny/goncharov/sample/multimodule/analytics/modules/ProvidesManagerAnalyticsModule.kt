package com.evgeny.goncharov.sample.multimodule.analytics.modules

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsFirebaseManagerImpl
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.CoreScope
import dagger.Binds
import dagger.Module

@Module
internal interface ProvidesManagerAnalyticsModule {

    @CoreScope
    @Binds
    fun AnalyticsFirebaseManagerImpl.provideAnalyticsManager(): AnalyticsManager
}