package com.evgeny.goncharov.multimodule.bottom_menu_impl.ui

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.multimodule.bottom_menu_impl.R
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment

internal class BottomMenuContainerFragment :
    ContainerFeatureFragment(R.layout.fragment_bottom_menu) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun releaseDependencies() {

    }

    companion object {
        fun newInstance() = BottomMenuContainerFragment()
    }
}