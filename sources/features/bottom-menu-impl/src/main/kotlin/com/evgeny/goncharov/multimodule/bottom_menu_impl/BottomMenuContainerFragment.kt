package com.evgeny.goncharov.multimodule.bottom_menu_impl

import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment

internal class BottomMenuContainerFragment :
    ContainerFeatureFragment(R.layout.fragment_bottom_menu) {

    override fun releaseDependencies() {

    }

    companion object {
        fun newInstance() = BottomMenuContainerFragment()
    }
}