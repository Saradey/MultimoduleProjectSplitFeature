package com.evgeny.goncharov.sample.multimodule.registration_impl.ui

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.registration_impl.di.contracts.RegistrationInternal
import com.evgeny.goncharov.sample.multimodule.registration_impl.navigation.RegistrationScreens
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigator
import com.evgeny.goncharov.sample.multimodule.navigation.routers.FeatureRouter
import com.evgeny.goncharov.sample.multimodule.registration_api.RegistrationApi
import com.github.terrakok.cicerone.NavigatorHolder

internal class RegistrationContainerFragment : ContainerFeatureFragment() {

    private val dependency: RegistrationInternal by lazy {
        getFeatureApi(RegistrationApi::class.java) as RegistrationInternal
    }
    override val navigator: FeatureNavigator by lazy {
        FeatureNavigator(this)
    }
    override val navigatorHolder: NavigatorHolder = dependency.provideFeatureNavigatorHolder()
    private val router: FeatureRouter = dependency.provideFeatureRouter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        startFeature()
    }

    private fun startFeature() {
        router.navigateToFeatureScreen(RegistrationScreens.goToTheRegistration())
    }

    override fun releaseDependencies() {
        releaseFeatureApi(RegistrationApi::class.java)
    }

    companion object {
        fun newInstance() = RegistrationContainerFragment()
    }
}