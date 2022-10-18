package com.evgeny.goncharov.sample.multimodule.di.modules

import com.evgeny.goncharov.sample.multimodule.di.contracts.MainActivityApi
import com.evgeny.goncharov.sample.multimodule.di.holder.MainActivityHolder
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
internal object FeatureHoldersModule {

    @[Singleton Provides]
    @[IntoMap ClassKey(MainActivityApi::class)]
    fun provideMainActivityHolder(featureContainer: FeatureContainer)
            : FeatureHolder<*> = MainActivityHolder(featureContainer)
}