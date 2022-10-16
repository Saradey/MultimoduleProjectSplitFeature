package com.evgeny.goncharov.sample.multimodule.di.components

import com.evgeny.goncharov.sample.multimodule.App
import com.evgeny.goncharov.sample.multimodule.di.modules.GlobalHoldersModule
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.BaseHolder
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [GlobalHoldersModule::class]
)
internal interface GlobalHoldersComponent {

    fun getGlobalHolders(): Map<Class<*>, BaseHolder<*>>

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance app: App,
            @BindsInstance featureContainerManager: FeatureContainerManager
        ): GlobalHoldersComponent
    }
}