package com.evgeny.goncharov.sample.multimodule.like_impl.ui

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.like_api.LikeApi
import com.evgeny.goncharov.sample.multimodule.like_impl.di.contracts.LikeInternal
import com.evgeny.goncharov.sample.multimodule.like_impl.navigation.LikeScreens
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigator
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureRouter
import com.github.terrakok.cicerone.NavigatorHolder

internal class LikeContainerFragment : ContainerFeatureFragment<LikeApi>() {

    override val dependency: LikeInternal by lazy {
        getFeatureApi(LikeApi::class.java) as LikeInternal
    }
    private val navigator: FeatureNavigator by lazy {
        FeatureNavigator(this)
    }
    private val navigatorHolder: NavigatorHolder = dependency.provideFeatureNavigatorHolder()
    private val router: FeatureRouter = dependency.provideFeatureRouter()
    override val backStackName: String = "LikeContainer"

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

    companion object {
        fun newInstance() = LikeContainerFragment()
    }
}