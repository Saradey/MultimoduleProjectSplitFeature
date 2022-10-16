package com.evgeny.goncharov.sample.multimodule.di.modules

import com.evgeny.goncharov.sample.multimodule.App
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.BaseHolder
import com.evgeny.goncharov.sample.multimodule.utils.StubGlobalHolder
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
internal object GlobalHoldersModule {

    @[Provides Singleton]
    @[IntoMap ClassKey(String::class)]
    fun provideBaseCoreHolder(featureContainer: FeatureContainerManager)
            : BaseHolder<*> = StubGlobalHolder(featureContainer)
}