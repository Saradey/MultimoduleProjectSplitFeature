package com.evgeny.goncharov.sample.multimodule.analytics.modules

import android.content.Context
import com.evgeny.goncharov.sample.multimodule.analytics.firebase.FirebaseAnalytics
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.CoreScope
import dagger.Module
import dagger.Provides

@Module
internal class AnalyticsProvidesModule {

    @CoreScope
    @Provides
    fun provideAnalyticsManager(context: Context): FirebaseAnalytics {
        return FirebaseAnalytics.getInstance(context)
    }
}