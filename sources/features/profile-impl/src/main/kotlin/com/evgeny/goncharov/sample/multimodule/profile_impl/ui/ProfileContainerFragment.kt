package com.evgeny.goncharov.sample.multimodule.profile_impl.ui

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigator
import com.evgeny.goncharov.sample.multimodule.navigation.routers.FeatureRouter
import com.evgeny.goncharov.sample.multimodule.profile_api.ProfileApi
import com.evgeny.goncharov.sample.multimodule.profile_impl.di.contracts.ProfileInternal
import com.evgeny.goncharov.sample.multimodule.profile_impl.navigation.ProfileScreens
import com.github.terrakok.cicerone.NavigatorHolder

internal class ProfileContainerFragment : ContainerFeatureFragment() {

    private val dependency: ProfileInternal by lazy {
        getFeatureApi(ProfileApi::class.java) as ProfileInternal
    }
    override val navigator: FeatureNavigator by lazy {
        FeatureNavigator(this)
    }
    private val router: FeatureRouter = dependency.provideFeatureRouter()
    override val navigatorHolder: NavigatorHolder = dependency.provideFeatureNavigatorHolder()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        savedInstanceState ?: startFeature()
    }

    private fun startFeature() {
        router.navigateToFeatureScreen(ProfileScreens.goToProfile())
    }

    override fun releaseDependencies() {
        releaseFeatureApi(ProfileApi::class.java)
    }

    companion object {

        fun newInstance() = ProfileContainerFragment()
    }
}