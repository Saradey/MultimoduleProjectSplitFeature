package com.evgeny.goncharov.sample.multimodule.di_core

import androidx.appcompat.app.AppCompatActivity
import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi
import com.evgeny.goncharov.sample.multimodule.di_core.engine.DI

public abstract class CoreActivity : AppCompatActivity() {

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            releaseDependency()
        }
    }

    protected fun getComponent(featureKey: Class<out ReleasableApi>): ReleasableApi =
        DI.getFeatureApi(featureKey)

    protected fun releaseComponent(featureKey: Class<out ReleasableApi>) {
        DI.releaseFeatureApi(featureKey)
    }

    protected abstract fun releaseDependency()
}