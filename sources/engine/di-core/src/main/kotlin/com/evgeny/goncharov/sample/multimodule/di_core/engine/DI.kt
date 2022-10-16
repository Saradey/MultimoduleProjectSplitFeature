package com.evgeny.goncharov.sample.multimodule.di_core.engine

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.container.NotInitializedFeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi

public object DI {

    private var featureContainer: FeatureContainer = NotInitializedFeatureContainer

    public fun initialize(featureContainer: FeatureContainer) {
        this.featureContainer = featureContainer
    }

    public fun getFeatureApi(key: Class<out ReleasableApi>): ReleasableApi {
        return featureContainer.getFeature(key)
    }

    public fun releaseFeature(key: Class<out ReleasableApi>) {
        featureContainer.releaseFeature(key)
    }

    public fun <D> getGlobalApi(key: Class<D>): D {
        return featureContainer.getGlobal(key)
    }
}