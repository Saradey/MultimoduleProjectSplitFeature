package com.evgeny.goncharov.sample.multimodule.like_impl.di

import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigationModule
import dagger.Component

@FeatureScope
@Component(
    modules = [
        FeatureNavigationModule::class
    ]
)
internal interface LikeComponent {

    @Component.Factory
    interface Factory {

        fun create(): LikeComponent
    }
}