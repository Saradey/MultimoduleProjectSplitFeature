package com.evgeny.goncharov.sample.multimodule.like_impl.di

import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.like_impl.di.contracts.LikeInternal
import com.evgeny.goncharov.sample.multimodule.navigation.di.FeatureNavigationModule
import dagger.Component

@FeatureScope
@Component(
    modules = [
        FeatureNavigationModule::class
    ]
)
internal interface LikeComponent : LikeInternal {

    @Component.Factory
    interface Factory {

        fun create(): LikeComponent
    }
}