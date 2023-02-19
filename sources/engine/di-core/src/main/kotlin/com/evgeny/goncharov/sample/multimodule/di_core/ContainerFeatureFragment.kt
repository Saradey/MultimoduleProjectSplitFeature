package com.evgeny.goncharov.sample.multimodule.di_core

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi
import com.evgeny.goncharov.sample.multimodule.di_core.engine.DI

public abstract class ContainerFeatureFragment <D : ReleasableApi>: Fragment {

    public constructor(@LayoutRes layoutId: Int) : super(layoutId)
    public constructor() : super(R.layout.fragment_feature_container)

    protected abstract val backStackName: String
    protected abstract val dependency: D

    override fun onDestroy() {
        super.onDestroy()
        releaseDependencies()
    }

    private fun releaseDependencies() {
        releaseFeatureApi(dependency::class.java)
    }

    protected fun getFeatureApi(key: Class<out ReleasableApi>): ReleasableApi =
        DI.getFeatureApi(key)

    private fun releaseFeatureApi(key: Class<out ReleasableApi>) {
        DI.releaseFeatureApi(key)
    }
}