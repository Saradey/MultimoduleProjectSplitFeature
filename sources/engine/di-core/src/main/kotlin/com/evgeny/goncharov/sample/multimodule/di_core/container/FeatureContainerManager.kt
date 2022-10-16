package com.evgeny.goncharov.sample.multimodule.di_core.container

import com.evgeny.goncharov.sample.multimodule.di_core.initializer.FeatureHolderInitializer

public interface FeatureContainerManager : FeatureContainer {

    public fun init(
        globalInitializer: FeatureHolderInitializer,
        featureInitializer: FeatureHolderInitializer
    ): FeatureContainerManager
}