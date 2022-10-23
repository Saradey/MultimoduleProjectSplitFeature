package com.evgeny.goncharov.multimodule.bottom_menu_impl.di

import com.evgeny.goncharov.multimodule.bottom_menu_impl.di.contracts.BottomMenuInternal
import com.evgeny.goncharov.multimodule.bottom_menu_impl.di.modules.ViewModelsBottomMenuModule
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        CoreNavigationApi::class
    ],
    modules = [
        ViewModelsBottomMenuModule::class
    ]
)
internal interface BottomMenuComponent : BottomMenuInternal {

    @Component.Factory
    interface Factory {

        fun create(
            coreNavigationApi: CoreNavigationApi
        ): BottomMenuComponent
    }
}