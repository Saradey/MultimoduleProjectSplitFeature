package com.evgeny.goncharov.sample.multimodule.registration_impl.ui

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.registration_impl.di.contracts.RegistrationInternal
import com.evgeny.goncharov.sample.multimodule.registration_impl.navigation.RegistrationScreens
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigator
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureRouter
import com.evgeny.goncharov.sample.multimodule.registration_api.RegistrationApi
import com.github.terrakok.cicerone.NavigatorHolder

internal class RegistrationContainerFragment : ContainerFeatureFragment<RegistrationApi>() {

    override val dependency: RegistrationInternal by lazy {
        getFeatureApi(RegistrationApi::class.java) as RegistrationInternal
    }
    private val navigator: FeatureNavigator by lazy {
        FeatureNavigator(this)
    }
    private val navigatorHolder: NavigatorHolder = dependency.provideFeatureNavigatorHolder()
    private val router: FeatureRouter = dependency.provideFeatureRouter()
    override val backStackName: String = "RegistrationContainer"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        startFeature()
    }

    private fun startFeature() {
        router.navigateToFeatureScreen(RegistrationScreens.goToTheRegistration())
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
        fun newInstance() = RegistrationContainerFragment()
    }
}