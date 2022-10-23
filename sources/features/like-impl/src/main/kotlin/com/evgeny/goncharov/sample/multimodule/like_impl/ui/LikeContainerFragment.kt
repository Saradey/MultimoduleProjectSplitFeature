package com.evgeny.goncharov.sample.multimodule.like_impl.ui

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.like_api.LikeApi
import com.evgeny.goncharov.sample.multimodule.like_impl.navigation.LikeScreens
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigator
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureRouter
import com.github.terrakok.cicerone.NavigatorHolder

internal class LikeContainerFragment : ContainerFeatureFragment() {

    private val dependency: LikeInternal by lazy {
        getFeatureApi(LikeApi::class.java) as LikeInternal
    }
    private val navigatorHolder: NavigatorHolder = dependency.provideFeatureNavigatorHolder()
    private val navigator: FeatureNavigator by lazy {
        FeatureNavigator(this)
    }
    private val router: FeatureRouter = dependency.provideFeatureRouter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        startFeature()
    }

    private fun startFeature() {
        router.navigateToFeatureScreen(LikeScreens.goToTheLike())
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
        releaseFeatureApi(LikeApi::class.java)
    }

    companion object {
        fun newInstance() = LikeContainerFragment()
    }
}