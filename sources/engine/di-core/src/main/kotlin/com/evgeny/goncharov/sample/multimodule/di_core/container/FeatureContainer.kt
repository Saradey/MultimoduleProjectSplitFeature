package com.evgeny.goncharov.sample.multimodule.di_core.container

import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi

public interface FeatureContainer {

    public fun getFeatureComponent(key: Class<out ReleasableApi>): ReleasableApi

    public fun releaseFeature(key: Class<out ReleasableApi>)

    public fun <D> getGlobalComponent(key: Class<D>): D
}