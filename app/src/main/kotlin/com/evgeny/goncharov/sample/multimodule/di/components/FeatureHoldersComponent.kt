package com.evgeny.goncharov.sample.multimodule.di.components

import com.evgeny.goncharov.sample.multimodule.di.modules.FeatureHoldersModule
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [FeatureHoldersModule::class]
)
internal interface FeatureHoldersComponent {

    fun getFeatureHolders(): Map<Class<*>, FeatureHolder<*>>

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance featureContainerManager: FeatureContainerManager
        ): FeatureHoldersComponent
    }
}