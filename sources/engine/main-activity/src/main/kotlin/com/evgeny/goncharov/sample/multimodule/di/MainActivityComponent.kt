package com.evgeny.goncharov.sample.multimodule.di

import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.navigation.api.LaunchersApi
import dagger.Component

@Component(
    dependencies = [
        CoreNavigationApi::class,
        LaunchersApi::class
    ]
)
private interface MainActivityComponent : MainActivityInternal {

    @Component.Factory
    interface Factory {
        fun create(
            coreNavigationApi: CoreNavigationApi,
            launchersApi: LaunchersApi
        ): MainActivityComponent
    }
}