package com.evgeny.goncharov.sample.multimodule.home_impl

import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment

internal class HomeContainerFragment : ContainerFeatureFragment() {

    override fun releaseDependencies() {

    }

    companion object {
        fun newInstance() = HomeContainerFragment()
    }
}