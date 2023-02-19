package com.evgeny.goncharov.sample.multimodule.like_impl.navigation

import com.evgeny.goncharov.sample.multimodule.like_api.LikeLauncher
import com.evgeny.goncharov.sample.multimodule.navigation.routers.GlobalRouter

public class LikeLauncherImpl(
    private val globalRouter: GlobalRouter
) : LikeLauncher {

    override fun launch() {
        globalRouter.navigateToFeatureContainer(LikeScreens.startFeature())
    }
}