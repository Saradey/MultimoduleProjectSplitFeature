package com.evgeny.goncharov.sample.multimodule.di_core.initializer

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.BaseHolder

public interface GlobalHolderInitializer {

    public fun init(featureContainerManager: FeatureContainerManager): Map<Class<*>, BaseHolder<*>>
}