package com.evgeny.goncharov.sample.multimodule.analytics.modules

import com.evgeny.goncharov.sample.multimodule.analytics.firebase.FirebaseAnalytics
import com.evgeny.goncharov.sample.multimodule.analytics.huawei.HiAnalytics
import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsFirebaseManagerImpl
import com.evgeny.goncharov.sample.multimodule.analytics.manager.HuaweiAnalyticsManagerImpl
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.CoreScope
import dagger.Module
import dagger.Provides

@Module
internal object ProvidesManagerAnalyticsModule {

    @CoreScope
    @Provides
    fun provideAnalyticsManager(
        firebaseAnalytics: FirebaseAnalytics,
        hiAnalytics: HiAnalytics,
        isHuaweiAnalytics: Boolean
    ): AnalyticsManager {
        return if(isHuaweiAnalytics) {
            HuaweiAnalyticsManagerImpl(hiAnalytics)
        } else {
            AnalyticsFirebaseManagerImpl(firebaseAnalytics)
        }
    }
}