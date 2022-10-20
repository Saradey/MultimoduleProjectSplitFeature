package com.evgeny.goncharov.sample.multimodule.di

import com.evgeny.goncharov.sample.multimodule.di.contracts.MainActivityInternal
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashLauncher
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [CoreNavigationApi::class]
)
internal interface MainActivityComponent : MainActivityInternal {

    @Component.Factory
    interface Factory {
        fun create(
            coreNavigationApi: CoreNavigationApi,
            @BindsInstance splashScreenLauncher: SplashLauncher
        ): MainActivityComponent
    }
}