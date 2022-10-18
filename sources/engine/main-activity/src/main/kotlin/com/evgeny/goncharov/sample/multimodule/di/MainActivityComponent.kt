package com.evgeny.goncharov.sample.multimodule.di

import com.evgeny.goncharov.sample.multimodule.di.contracts.MainActivityInternal
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.di_core.navigation.LaunchersApi
import dagger.Component

@Component(
    dependencies = [
        CoreNavigationApi::class,
        LaunchersApi::class
    ]
)
internal interface MainActivityComponent : MainActivityInternal {

    @Component.Factory
    interface Factory {
        fun create(
            coreNavigationApi: CoreNavigationApi,
            launchersApi: LaunchersApi
        ): MainActivityComponent
    }
}