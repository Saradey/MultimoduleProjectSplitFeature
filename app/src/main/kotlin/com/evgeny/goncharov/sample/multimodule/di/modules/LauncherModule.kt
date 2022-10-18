package com.evgeny.goncharov.sample.multimodule.di.modules

import com.evgeny.goncharov.sample.multimodule.navigation.GlobalRouter
import com.evgeny.goncharov.sample.multimodule.navigation.contracts.BaseLauncher
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashScreenLauncher
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.navigation.SplashScreenLauncherImpl
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
internal object LauncherModule {

    @Provides
    @[Singleton IntoMap ClassKey(SplashScreenLauncher::class)]
    fun provideBalanceHistoryLauncher(globalRouter: GlobalRouter): BaseLauncher {
        return SplashScreenLauncherImpl(globalRouter)
    }
}