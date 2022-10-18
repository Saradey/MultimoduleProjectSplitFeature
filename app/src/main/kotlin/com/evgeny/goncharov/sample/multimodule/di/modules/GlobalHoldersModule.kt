package com.evgeny.goncharov.sample.multimodule.di.modules

import com.evgeny.goncharov.sample.multimodule.di.holder.LaunchersHolder
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.BaseHolder
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.navigation.api.LaunchersApi
import com.evgeny.goncharov.sample.multimodule.navigation.holder.NavigationHolder
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
}