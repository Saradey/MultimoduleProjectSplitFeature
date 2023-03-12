package com.evgeny.goncharov.sample.multimodule.di.modules

import com.evgeny.goncharov.multimodule.bottom_menu_impl.navigation.BottomMenuLauncherImpl
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuLauncher
import com.evgeny.goncharov.sample.multimodule.catalog_api.CatalogLauncher
import com.evgeny.goncharov.sample.multimodule.catalog_impl.navigation.CatalogLauncherImpl
import com.evgeny.goncharov.sample.multimodule.navigation.routers.GlobalRouter
import com.evgeny.goncharov.sample.multimodule.di_core.navigation.BaseLauncher
import com.evgeny.goncharov.sample.multimodule.home_api.HomeLauncher
import com.evgeny.goncharov.sample.multimodule.home_impl.navigation.HomeLauncherImpl
import com.evgeny.goncharov.sample.multimodule.like_api.LikeLauncher
import com.evgeny.goncharov.sample.multimodule.like_impl.navigation.LikeLauncherImpl
import com.evgeny.goncharov.sample.multimodule.registration_api.AuthorizationLauncher
import com.evgeny.goncharov.sample.multimodule.registration_impl.navigation.RegistrationLauncherImpl
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashLauncher
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.navigation.SplashLauncherImpl
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
internal object LauncherModule {

    @Provides
    @[Singleton IntoMap ClassKey(SplashLauncher::class)]
    fun provideBalanceHistoryLauncher(globalRouter: GlobalRouter): BaseLauncher {
        return SplashLauncherImpl(globalRouter)
    }

    @Provides
    @[Singleton IntoMap ClassKey(BottomMenuLauncher::class)]
    fun provideBottomMenuLauncher(globalRouter: GlobalRouter): BaseLauncher {
        return BottomMenuLauncherImpl(globalRouter)
    }

    @Provides
    @[Singleton IntoMap ClassKey(HomeLauncher::class)]
    fun provideHomeLauncher(globalRouter: GlobalRouter): BaseLauncher {
        return HomeLauncherImpl(globalRouter)
    }

    @Provides
    @[Singleton IntoMap ClassKey(CatalogLauncher::class)]
    fun provideCatalogLauncher(globalRouter: GlobalRouter): BaseLauncher {
        return CatalogLauncherImpl(globalRouter)
    }

    @Provides
    @[Singleton IntoMap ClassKey(AuthorizationLauncher::class)]
    fun provideRegistrationLauncher(globalRouter: GlobalRouter): BaseLauncher {
        return RegistrationLauncherImpl(globalRouter)
    }

    @Provides
    @[Singleton IntoMap ClassKey(LikeLauncher::class)]
    fun provideLikeLauncher(globalRouter: GlobalRouter): BaseLauncher {
        return LikeLauncherImpl(globalRouter)
    }
}