package com.evgeny.goncharov.sample.multimodule.home_impl.ui

import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.home_api.HomeApi

internal class HomeContainerFragment : ContainerFeatureFragment() {



    override fun releaseDependencies() {
        releaseFeatureApi(HomeApi::class.java)
    }

    companion object {
        fun newInstance() = HomeContainerFragment()
    }
}