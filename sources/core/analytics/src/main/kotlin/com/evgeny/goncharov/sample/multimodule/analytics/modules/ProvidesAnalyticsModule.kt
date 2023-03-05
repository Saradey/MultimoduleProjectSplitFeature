package com.evgeny.goncharov.sample.multimodule.analytics.modules

import android.content.Context
import com.evgeny.goncharov.sample.multimodule.analytics.firebase.FirebaseAnalytics
import com.evgeny.goncharov.sample.multimodule.analytics.huawei.HiAnalytics
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.CoreScope
import dagger.Module
import dagger.Provides

@Module
internal object ProvidesAnalyticsModule {

    @CoreScope
    @Provides
    fun provideAnalyticsManager(context: Context): FirebaseAnalytics {
        return FirebaseAnalytics.getInstance(context)
    }

    @CoreScope
    @Provides
    fun provideHiAnalytics(context: Context): HiAnalytics {
        return HiAnalytics.getInstance(context)
    }
}