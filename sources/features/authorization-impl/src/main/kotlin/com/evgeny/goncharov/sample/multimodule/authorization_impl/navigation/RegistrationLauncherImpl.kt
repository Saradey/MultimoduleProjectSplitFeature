package com.evgeny.goncharov.sample.multimodule.authorization_impl.navigation

import com.evgeny.goncharov.sample.multimodule.navigation.routers.GlobalRouter
import com.evgeny.goncharov.sample.multimodule.authorization_api.AuthorizationLauncher

public class RegistrationLauncherImpl(
    private val globalRouter: GlobalRouter
) : AuthorizationLauncher {

    override fun launch() {
        globalRouter.navigateToFeatureContainer(RegistrationScreens.startFeature())
    }
}