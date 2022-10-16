package com.evgeny.goncharov.sample.multimodule.di_core

import androidx.appcompat.app.AppCompatActivity

public abstract class CoreActivity : AppCompatActivity() {

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            releaseDependency()
        }
    }

    protected fun getFeatureApi(featureKey: Class<out ReleasableApi>) =
        DI.getFeatureApi(featureKey)

    protected fun releaseFeatureApi(featureKey: Class<out ReleasableApi>) =
        DI.releaseFeature(featureKey)

    protected fun <D> getGlobalApi(key: Class<D>) =
        DI.getGlobalApi(key)

    protected abstract fun releaseDependency()
}