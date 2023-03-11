package com.evgeny.goncharov.sample.multimodule.di.modules

import android.content.Context
import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.analytics.holder.AnalyticsHolder
import com.evgeny.goncharov.sample.multimodule.di.holder.LaunchersHolder
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.BaseHolder
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.di_core.navigation.LaunchersApi
import com.evgeny.goncharov.sample.multimodule.navigation.holder.NavigationHolder
import com.evgeny.goncharov.sample.multimodule.user.di.api.UserApi
import com.evgeny.goncharov.sample.multimodule.user.holder.UserHolder
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
internal object GlobalHoldersModule {

    @[Provides Singleton]
    @[IntoMap ClassKey(CoreNavigationApi::class)]
    fun provideNavigationHolder(featureContainer: FeatureContainerManager): BaseHolder<*> =
        NavigationHolder(featureContainer)

    @[Provides Singleton]
    @[IntoMap ClassKey(LaunchersApi::class)]
    fun provideLaunchersHolder(featureContainer: FeatureContainerManager): BaseHolder<*> =
        LaunchersHolder(featureContainer)

    @[Provides Singleton]
    @[IntoMap ClassKey(AnalyticsDependencyApi::class)]
    fun provideAnalyticsHolder(
        featureContainer: FeatureContainerManager,
        appContext: Context,
        isHuawei: Boolean
    ): BaseHolder<*> = AnalyticsHolder(featureContainer, appContext, isHuawei)

    @[Provides Singleton]
    @[IntoMap ClassKey(UserApi::class)]
    fun provideUserApiHolder(
        featureContainer: FeatureContainerManager,
        appContext: Context
    ): BaseHolder<*> = UserHolder(featureContainer, appContext)
}