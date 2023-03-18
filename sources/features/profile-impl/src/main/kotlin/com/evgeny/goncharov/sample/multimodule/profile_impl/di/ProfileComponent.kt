package com.evgeny.goncharov.sample.multimodule.profile_impl.di

import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.navigation.di.FeatureNavigationModule
import com.evgeny.goncharov.sample.multimodule.profile_impl.di.contracts.ProfileInternal
import com.evgeny.goncharov.sample.multimodule.profile_impl.di.modules.ViewModelsProfileModule
import dagger.Component

@FeatureScope
@Component(
    modules = [
        FeatureNavigationModule::class,
        ViewModelsProfileModule::class
    ]
)
internal interface ProfileComponent : ProfileInternal {


    @Component.Factory
    interface Factory {

        fun create(): ProfileComponent
    }
}