package com.evgeny.goncharov.sample.multimodule.authorization_impl.ui

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.authorization_impl.di.contracts.AuthorizationInternal
import com.evgeny.goncharov.sample.multimodule.authorization_impl.navigation.RegistrationScreens
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigator
import com.evgeny.goncharov.sample.multimodule.navigation.routers.FeatureRouter
import com.evgeny.goncharov.sample.multimodule.authorization_api.AuthorizationApi
import com.github.terrakok.cicerone.NavigatorHolder

internal class AuthorizationContainerFragment : ContainerFeatureFragment() {

    private val dependency: AuthorizationInternal by lazy {
        getFeatureApi(AuthorizationApi::class.java) as AuthorizationInternal
    }
    override val navigator: FeatureNavigator by lazy {
        FeatureNavigator(this)
    }
    override val navigatorHolder: NavigatorHolder = dependency.provideFeatureNavigatorHolder()
    private val router: FeatureRouter = dependency.provideFeatureRouter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        savedInstanceState ?: startFeature()
    }

    private fun startFeature() {
        router.navigateToFeatureScreen(RegistrationScreens.goToTheRegistration())
    }

    override fun releaseDependencies() {
        releaseFeatureApi(AuthorizationApi::class.java)
    }

    companion object {
        fun newInstance() = AuthorizationContainerFragment()
    }
}