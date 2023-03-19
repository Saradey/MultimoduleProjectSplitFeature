package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.ui

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigator
import com.evgeny.goncharov.sample.multimodule.navigation.routers.FeatureRouter
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
    private val onBackPressed = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            requireActivity().finish()
        }
    }
    override val navigatorHolder: NavigatorHolder = dependency.provideFeatureNavigatorHolder()
    private val router: FeatureRouter = dependency.provideFeatureRouter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        savedInstanceState ?: startFeature()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressed)
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