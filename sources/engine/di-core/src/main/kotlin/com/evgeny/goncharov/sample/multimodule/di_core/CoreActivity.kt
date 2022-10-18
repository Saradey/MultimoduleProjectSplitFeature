package com.evgeny.goncharov.sample.multimodule.di_core

import androidx.appcompat.app.AppCompatActivity
import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi
import com.evgeny.goncharov.sample.multimodule.di_core.engine.DI
import com.evgeny.goncharov.sample.multimodule.di_core.navigation.BaseLauncher

public abstract class CoreActivity : AppCompatActivity() {

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            releaseDependency()
        }
    }

    protected fun getFeatureApi(featureKey: Class<out ReleasableApi>): ReleasableApi =
        DI.getFeatureApi(featureKey)

    protected fun releaseFeatureApi(featureKey: Class<out ReleasableApi>) {
        DI.releaseFeatureApi(featureKey)
    }

    protected fun <L : BaseLauncher> getFeatureLauncher(key: Class<L>): BaseLauncher {
        return DI.getFeatureLauncher(key)
    }

    protected abstract fun releaseDependency()
}