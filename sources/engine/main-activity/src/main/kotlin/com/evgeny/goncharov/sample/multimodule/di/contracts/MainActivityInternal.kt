package com.evgeny.goncharov.sample.multimodule.di.contracts

import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.di_core.navigation.LaunchersApi
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashScreenLauncher

internal interface MainActivityInternal : MainActivityApi, CoreNavigationApi {

    fun provideSplashLauncher(): SplashScreenLauncher
}