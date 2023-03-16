package com.evgeny.goncharov.sample.multimodule.profile_impl.di

import com.evgeny.goncharov.sample.multimodule.navigation.di.FeatureNavigationModule
import com.evgeny.goncharov.sample.multimodule.profile_impl.di.contracts.ProfileInternal
import dagger.Component

@Component(modules = [FeatureNavigationModule::class])
internal interface ProfileComponent : ProfileInternal {


    @Component.Factory
    interface Factory {

        fun create(): ProfileComponent
    }
}