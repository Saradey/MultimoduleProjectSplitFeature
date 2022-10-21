package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di

import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di.contracts.SplashInternal
import dagger.Component


@Component
internal interface SplashComponent : SplashInternal {

    @Component.Factory
    interface Factory {

        fun create(): SplashComponent
    }
}