package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.ui

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigator
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureRouter
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashApi
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di.contracts.SplashInternal
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.navigation.screens.SplashScreens
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder

internal class SplashContainerFragment : ContainerFeatureFragment() {

    private val dependency: SplashInternal by lazy {
        getFeatureApi(SplashApi::class.java) as SplashInternal
    }
    override val navigator: Navigator by lazy {
        FeatureNavigator(this)
    }
    override val navigatorHolder: NavigatorHolder = dependency.provideFeatureNavigatorHolder()
    private val router: FeatureRouter = dependency.provideFeatureRouter()
    override val backStackName: String = "SplashContainer"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        savedInstanceState ?: startFeature()
    }

    private fun startFeature() {
        router.navigateToFeatureScreen(SplashScreens.goToTheSplashFragment())
    }

    override fun releaseDependencies() {
        releaseFeatureApi(SplashApi::class.java)
    }

    companion object {
        fun newInstance() = SplashContainerFragment()
    }
}