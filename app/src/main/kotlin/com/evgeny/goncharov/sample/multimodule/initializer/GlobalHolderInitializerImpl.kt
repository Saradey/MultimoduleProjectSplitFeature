package com.evgeny.goncharov.sample.multimodule.initializer

import android.app.Application
import com.evgeny.goncharov.sample.multimodule.di.components.DaggerGlobalHoldersComponent
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.di_core.initializer.FeatureHolderInitializer

internal class GlobalHolderInitializerImpl(
    private val featureContainerManager: FeatureContainerManager,
    private val app: Application
) : FeatureHolderInitializer {

    override fun init(): Map<Class<*>, FeatureHolder<*>> {
        return DaggerGlobalHoldersComponent.factory()
            .create(app, featureContainerManager)
    }
}