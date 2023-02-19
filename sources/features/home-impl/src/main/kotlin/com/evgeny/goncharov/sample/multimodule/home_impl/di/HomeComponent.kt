package com.evgeny.goncharov.sample.multimodule.home_impl.di

import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.home_impl.di.contracts.HomeInternal
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.navigation.di.FeatureNavigationModule
import dagger.Component

@FeatureScope
@Component(
    modules = [
        FeatureNavigationModule::class,
    ],
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