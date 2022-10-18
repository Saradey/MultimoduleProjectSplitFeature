package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.navigation

import com.evgeny.goncharov.sample.multimodule.navigation.GlobalRouter
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashScreenLauncher

public class SplashScreenLauncherImpl(
    private val globalRouter: GlobalRouter
) : SplashScreenLauncher {

    override fun launch() {
    }
}