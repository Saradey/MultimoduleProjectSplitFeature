package com.evgeny.goncharov.sample.multimodule.registration_impl.di

import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.registration_impl.di.contracts.RegistrationInternal
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigationModule
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
internal interface RegistrationComponent : RegistrationInternal {

    @Component.Factory
    interface Factory {
        fun create(
            coreNavigationApi: CoreNavigationApi
        ): RegistrationComponent
    }
}