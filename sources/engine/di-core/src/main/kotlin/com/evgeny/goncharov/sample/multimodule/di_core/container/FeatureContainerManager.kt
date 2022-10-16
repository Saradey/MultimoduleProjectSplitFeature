package com.evgeny.goncharov.sample.multimodule.di_core.container

public interface FeatureContainerManager : FeatureContainer {

    public fun init(
        globalInitializer: ComponentHolderInitializer,
        featureInitializer: ComponentHolderInitializer
    ): FeatureContainerManager
}