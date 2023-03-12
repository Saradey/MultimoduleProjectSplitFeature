package com.evgeny.goncharov.sample.multimodule.registration_impl.navigation

import com.evgeny.goncharov.sample.multimodule.navigation.routers.GlobalRouter
import com.evgeny.goncharov.sample.multimodule.registration_api.AuthorizationLauncher

public class RegistrationLauncherImpl(
    private val globalRouter: GlobalRouter
) : AuthorizationLauncher {

    override fun launch() {
        globalRouter.navigateToFeatureContainer(RegistrationScreens.startFeature())
    }
}