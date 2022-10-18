package com.evgeny.goncharov.sample.multimodule.di_core.engine

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerImpl
import com.evgeny.goncharov.sample.multimodule.di_core.container.NotInitializedFeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi
import com.evgeny.goncharov.sample.multimodule.di_core.initializer.FeatureHolderInitializer
import com.evgeny.goncharov.sample.multimodule.di_core.initializer.GlobalHolderInitializer
import com.evgeny.goncharov.sample.multimodule.di_core.navigation.BaseLauncher

public object DI {

    private var featureContainer: FeatureContainer = NotInitializedFeatureContainer

    public fun initialize(
        globalHolderInitializer: GlobalHolderInitializer,
        featureHolderInitializer: FeatureHolderInitializer
    ) {
        val featureContainer = FeatureContainerImpl()
        featureContainer.init(
            globalHolderInitializer,
            featureHolderInitializer
        )
        this.featureContainer = featureContainer
    }

    public fun getFeatureApi(key: Class<out ReleasableApi>): ReleasableApi {
        return featureContainer.getFeatureComponent(key)
    }

    public fun releaseFeatureApi(key: Class<out ReleasableApi>) {
        featureContainer.releaseFeatureComponent(key)
    }

    public fun <D> getGlobalApi(key: Class<D>): D {
        return featureContainer.getGlobalComponent(key)
    }

    public fun <L : BaseLauncher> getFeatureLauncher(key: Class<L>): BaseLauncher {
        return featureContainer.getFeatureLauncher(key)
    }
}