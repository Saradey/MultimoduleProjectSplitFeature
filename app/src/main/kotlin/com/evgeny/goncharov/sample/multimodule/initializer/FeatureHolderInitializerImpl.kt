package com.evgeny.goncharov.sample.multimodule.initializer

import com.evgeny.goncharov.sample.multimodule.di.components.DaggerFeatureHoldersComponent
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.di_core.initializer.FeatureHolderInitializer

internal class FeatureHolderInitializerImpl(
    private val featureContainerManager: FeatureContainerManager
) : FeatureHolderInitializer {

    override fun init(): Map<Class<*>, FeatureHolder<*>> {
        return DaggerFeatureHoldersComponent.factory().create(
            featureContainerManager
        ).getFeatureHolders()
    }
}