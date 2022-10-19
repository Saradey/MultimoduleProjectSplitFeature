package com.evgeny.goncharov.sample.multimodule.di_core.holder

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi
import com.evgeny.goncharov.sample.multimodule.di_core.navigation.BaseLauncher

public abstract class FeatureHolder<C : ReleasableApi>(container: FeatureContainer) :
    BaseHolder<C>(container) {

    public fun releaseFeature() {
        componentApi = null
    }

    @Suppress("UNCHECKED_CAST")
    protected fun <L : BaseLauncher> getFeatureLauncher(key: Class<L>): L {
        return container.getFeatureLauncher(key) as L
    }
}