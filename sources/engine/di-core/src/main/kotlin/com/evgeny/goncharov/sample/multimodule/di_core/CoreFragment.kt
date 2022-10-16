package com.evgeny.goncharov.sample.multimodule.di_core

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi

public abstract class CoreFragment : Fragment {
    public constructor(@LayoutRes layoutId: Int) : super(layoutId)
    public constructor() : super()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        resolveDependencies()
    }

    override fun onStop() {
        super.onStop()
        if (isRemoving && requireActivity().isFinishing) {
            releaseDependencies()
        }
    }

    protected open fun resolveDependencies() {}

    protected open fun releaseDependencies() {}

    protected fun releaseFeatureApi(key: Class<out ReleasableApi>) =
        DI.releaseFeature(key)

    protected fun getFeatureApi(key: Class<out ReleasableApi>) =
        DI.getFeatureApi(key)
}