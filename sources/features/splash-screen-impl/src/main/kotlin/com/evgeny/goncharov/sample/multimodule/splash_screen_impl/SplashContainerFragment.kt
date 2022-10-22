package com.evgeny.goncharov.sample.multimodule.splash_screen_impl

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigator
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashApi
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di.contracts.SplashInternal

internal class SplashContainerFragment : ContainerFeatureFragment() {

    private val dependency: SplashInternal by lazy {
        getFeatureApi(SplashApi::class.java) as SplashInternal
    }
    private val navigatorHolder = dependency.provideFeatureNavigatorHolder()
    private val navigator = FeatureNavigator(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun releaseDependencies() {
        releaseFeatureApi(SplashApi::class.java)
    }

    companion object {
        fun newInstance() = SplashContainerFragment()
    }
}