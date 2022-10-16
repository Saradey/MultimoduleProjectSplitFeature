package com.evgeny.goncharov.sample.multimodule.di_core.container

import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi

internal object NotInitializedFeatureContainer : FeatureContainer {
    override fun getFeature(key: Class<out ReleasableApi>) =
        throw IllegalStateException(ERROR_MASSAGE)

    override fun releaseFeature(key: Class<out ReleasableApi>) =
        throw IllegalStateException(ERROR_MASSAGE)

    override fun <D> getGlobal(key: Class<D>) = throw IllegalStateException(ERROR_MASSAGE)

    private const val ERROR_MASSAGE = "Need initialize FeatureContainer"
}