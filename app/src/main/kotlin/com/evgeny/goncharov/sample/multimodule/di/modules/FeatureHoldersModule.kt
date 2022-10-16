package com.evgeny.goncharov.sample.multimodule.di.modules

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.utils.StubFeatureHolder
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
internal object FeatureHoldersModule {

    @[Singleton Provides]
    @[IntoMap ClassKey(String::class)]
    fun provideStubFeatureHolder(featureContainer: FeatureContainerManager)
            : FeatureHolder<*> = StubFeatureHolder(featureContainer)
}