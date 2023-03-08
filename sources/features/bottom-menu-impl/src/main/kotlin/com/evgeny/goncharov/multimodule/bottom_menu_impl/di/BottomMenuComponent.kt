package com.evgeny.goncharov.multimodule.bottom_menu_impl.di

import com.evgeny.goncharov.multimodule.bottom_menu_impl.di.contracts.BottomMenuInternal
import com.evgeny.goncharov.multimodule.bottom_menu_impl.di.modules.ViewModelsBottomMenuModule
import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.catalog_api.CatalogLauncher
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.home_api.HomeLauncher
import com.evgeny.goncharov.sample.multimodule.like_api.LikeLauncher
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.registration_api.RegistrationLauncher
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        CoreNavigationApi::class,
        AnalyticsDependencyApi::class,
    ],
    modules = [
        ViewModelsBottomMenuModule::class
    ]
)
internal interface BottomMenuComponent : BottomMenuInternal {

    @Component.Factory
    interface Factory {

        fun create(
            coreNavigationApi: CoreNavigationApi,
            analyticsDependencyApi: AnalyticsDependencyApi,
            @BindsInstance homeLauncher: HomeLauncher,
            @BindsInstance catalogLauncher: CatalogLauncher,
            @BindsInstance registrationLauncher: RegistrationLauncher,
            @BindsInstance likeLauncher: LikeLauncher
        ): BottomMenuComponent
    }
}