package com.evgeny.goncharov.sample.multimodule.di_core.container

import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi

public interface FeatureContainerManager {

    public fun init(
        globalInitializer: ComponentHolderInitializer,
        featureInitializer: ComponentHolderInitializer
    ): FeatureContainerManager

    public fun getFeatureHolder(key: Class<out ReleasableApi>): FeatureHolder<out ReleasableApi>
}