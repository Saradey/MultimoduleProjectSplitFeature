package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di

import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di.contracts.SplashInternal
import dagger.Component


@Component(
    dependencies = [
        CoreNavigationApi::class
    ]
)
internal interface SplashComponent : SplashInternal {

    @Component.Factory
    interface Factory {

        fun create(
            coreNavigationApi: CoreNavigationApi
        ): SplashComponent
    }
}