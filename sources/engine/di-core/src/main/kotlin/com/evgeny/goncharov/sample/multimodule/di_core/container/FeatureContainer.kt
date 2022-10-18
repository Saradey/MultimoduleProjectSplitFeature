package com.evgeny.goncharov.sample.multimodule.di_core.container

import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi
import com.evgeny.goncharov.sample.multimodule.di_core.navigation.BaseLauncher

public interface FeatureContainer {

    public fun getFeatureComponent(key: Class<out ReleasableApi>): ReleasableApi

    public fun releaseFeatureComponent(key: Class<out ReleasableApi>)

    public fun <D> getGlobalComponent(key: Class<D>): D

    public fun <L : BaseLauncher> getFeatureLauncher(key: Class<L>): BaseLauncher
}