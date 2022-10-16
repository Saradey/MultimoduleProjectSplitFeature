package com.evgeny.goncharov.sample.multimodule.di_core.container

import com.evgeny.goncharov.sample.multimodule.di_core.initializer.FeatureHolderInitializer
import com.evgeny.goncharov.sample.multimodule.di_core.initializer.GlobalHolderInitializer

public interface FeatureContainerManager : FeatureContainer {

    public fun init(
        globalInitializer: GlobalHolderInitializer,
        featureInitializer: FeatureHolderInitializer
    ): FeatureContainerManager
}