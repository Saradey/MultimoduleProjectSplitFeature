package com.evgeny.goncharov.sample.multimodule.di_core

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi
import com.evgeny.goncharov.sample.multimodule.di_core.engine.DI

public abstract class CoreFragment : Fragment {
    public constructor(@LayoutRes layoutId: Int) : super(layoutId)
    public constructor() : super()

    protected fun getFeatureApi(key: Class<out ReleasableApi>): ReleasableApi =
        DI.getFeatureApi(key)
}