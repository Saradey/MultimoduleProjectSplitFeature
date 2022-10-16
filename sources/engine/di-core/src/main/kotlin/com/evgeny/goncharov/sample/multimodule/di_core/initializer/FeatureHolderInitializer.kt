package com.evgeny.goncharov.sample.multimodule.di_core.initializer

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder

public interface FeatureHolderInitializer {

    public fun init(featureContainerManager: FeatureContainerManager): Map<Class<*>, FeatureHolder<*>>
}