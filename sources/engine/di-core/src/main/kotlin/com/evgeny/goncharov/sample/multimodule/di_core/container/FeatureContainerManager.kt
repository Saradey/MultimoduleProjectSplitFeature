package com.evgeny.goncharov.sample.multimodule.di_core.container

import com.evgeny.goncharov.sample.multimodule.di_core.initializer.HolderInitializer

public interface FeatureContainerManager : FeatureContainer {

    public fun init(
        globalInitializer: HolderInitializer,
        featureInitializer: HolderInitializer
    ): FeatureContainerManager
}