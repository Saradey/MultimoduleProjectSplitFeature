package com.evgeny.goncharov.sample.multimodule.home_impl.di

import com.evgeny.goncharov.sample.multimodule.home_impl.di.contracts.HomeInternal
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import dagger.Component

@Component(
    dependencies = [
        CoreNavigationApi::class
    ]
)
internal interface HomeComponent : HomeInternal {

    @Component.Factory
    interface Factory {
        fun create(
            coreNavigationApi: CoreNavigationApi
        ): HomeComponent
    }
}