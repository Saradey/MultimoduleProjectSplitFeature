package com.evgeny.goncharov.sample.multimodule.home_impl.navigation

import com.evgeny.goncharov.sample.multimodule.home_api.HomeLauncher
import com.evgeny.goncharov.sample.multimodule.navigation.GlobalRouter

public class HomeLauncherImpl(
    private val globalRouter: GlobalRouter
) : HomeLauncher {

    override fun launch() {
        globalRouter.navigateToFeatureContainer(HomeScreens.startFeature())
    }
}