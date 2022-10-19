package com.evgeny.goncharov.sample.multimodule.di_core

import androidx.fragment.app.Fragment
import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi
import com.evgeny.goncharov.sample.multimodule.di_core.engine.DI

public abstract class ContainerFeatureFragment : Fragment(R.layout.fragment_feature_container) {

    override fun onStop() {
        super.onStop()
        if (isRemoving) {
            releaseDependencies()
        }
    }

    protected abstract fun releaseDependencies()

    protected fun releaseFeatureApi(key: Class<out ReleasableApi>) {
        DI.releaseFeatureApi(key)
    }
}