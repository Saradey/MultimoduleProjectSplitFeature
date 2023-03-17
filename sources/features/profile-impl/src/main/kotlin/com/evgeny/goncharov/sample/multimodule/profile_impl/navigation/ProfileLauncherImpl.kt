package com.evgeny.goncharov.sample.multimodule.profile_impl.navigation

import com.evgeny.goncharov.sample.multimodule.navigation.routers.GlobalRouter
import com.evgeny.goncharov.sample.multimodule.profile_api.ProfileLauncher

public class ProfileLauncherImpl(
    private val globalRouter: GlobalRouter
) : ProfileLauncher {

    override fun launchNewRoot() {
        globalRouter.newRootScreenFeatureContainer(ProfileScreens.startFeature())
    }

    override fun launch() {
        globalRouter.navigateToFeatureContainer(ProfileScreens.startFeature())
    }
}