package com.evgeny.goncharov.sample.multimodule.home_impl.ui

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.home_api.HomeApi
import com.evgeny.goncharov.sample.multimodule.home_impl.di.contracts.HomeInternal
import com.evgeny.goncharov.sample.multimodule.home_impl.navigation.HomeScreens
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigator
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureRouter
import com.github.terrakok.cicerone.NavigatorHolder

internal class HomeContainerFragment : ContainerFeatureFragment() {

    private val dependency: HomeInternal by lazy {
        getFeatureApi(HomeApi::class.java) as HomeInternal
    }
    private val navigator: FeatureNavigator by lazy {
        FeatureNavigator(this)
    }
    private val navigatorHolder: NavigatorHolder = dependency.provideFeatureNavigatorHolder()
    private val router: FeatureRouter = dependency.provideFeatureRouter()
    override val backStackName: String = "HomeContainer"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        startFeature()
    }

    private fun startFeature() {
        router.navigateToFeatureScreen(HomeScreens.goToTheHomeFragment())
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
        releaseFeatureApi(HomeApi::class.java)
    }

    companion object {
        fun newInstance() = HomeContainerFragment()
    }
}