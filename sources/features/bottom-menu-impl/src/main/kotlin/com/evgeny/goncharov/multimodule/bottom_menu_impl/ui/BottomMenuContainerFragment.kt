package com.evgeny.goncharov.multimodule.bottom_menu_impl.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.evgeny.goncharov.multimodule.bottom_menu_impl.R
import com.evgeny.goncharov.multimodule.bottom_menu_impl.di.contracts.BottomMenuInternal
import com.evgeny.goncharov.multimodule.bottom_menu_impl.view.models.BottomMenuContainerViewModel
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuApi
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment

internal class BottomMenuContainerFragment :
    ContainerFeatureFragment(R.layout.fragment_bottom_menu) {

    private val dependency: BottomMenuInternal by lazy {
        getFeatureApi(BottomMenuApi::class.java) as BottomMenuInternal
    }
    private val viewModel: BottomMenuContainerViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun releaseDependencies() {
        releaseFeatureApi(BottomMenuApi::class.java)
    }

    companion object {
        fun newInstance() = BottomMenuContainerFragment()
    }
}