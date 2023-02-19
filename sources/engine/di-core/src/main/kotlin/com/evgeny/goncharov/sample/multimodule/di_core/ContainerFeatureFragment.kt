package com.evgeny.goncharov.sample.multimodule.di_core

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi
import com.evgeny.goncharov.sample.multimodule.di_core.engine.DI

public abstract class ContainerFeatureFragment : Fragment {

    public constructor(@LayoutRes layoutId: Int) : super(layoutId)
    public constructor() : super(R.layout.fragment_feature_container)

    public abstract val backStackName: String

    override fun onDestroy() {
        super.onDestroy()
        releaseDependencies()
    }

    protected abstract fun releaseDependencies()

    protected fun getFeatureApi(key: Class<out ReleasableApi>): ReleasableApi =
        DI.getFeatureApi(key)

    protected fun releaseFeatureApi(key: Class<out ReleasableApi>) {
        DI.releaseFeatureApi(key)
    }
}