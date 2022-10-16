package com.evgeny.goncharov.sample.multimodule.di_core.holder

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi

public abstract class FeatureHolder<C : ReleasableApi>(container: FeatureContainerManager) :
    BaseHolder<C>(container) {

    public fun releaseFeature() {
        componentApi = null
    }
}