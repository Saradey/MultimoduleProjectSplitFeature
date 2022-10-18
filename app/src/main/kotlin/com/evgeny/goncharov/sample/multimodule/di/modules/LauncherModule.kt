package com.evgeny.goncharov.sample.multimodule.di.modules

import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashScreenLauncher
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.navigation.SplashScreenLauncherImpl
import dagger.Binds
import dagger.Module

@Module
internal interface LauncherModule {

    @Binds
    fun SplashScreenLauncherImpl.bindSplashScreenLauncher(): SplashScreenLauncher
}