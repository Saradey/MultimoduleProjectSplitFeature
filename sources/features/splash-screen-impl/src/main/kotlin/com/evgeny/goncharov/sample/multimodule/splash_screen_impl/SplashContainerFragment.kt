package com.evgeny.goncharov.sample.multimodule.splash_screen_impl

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment

internal class SplashContainerFragment : ContainerFeatureFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    override fun releaseDependencies() {
    }

    companion object {
        fun newInstance() = SplashContainerFragment()
    }
}