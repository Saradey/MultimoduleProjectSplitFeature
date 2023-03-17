package com.evgeny.goncharov.multimodule.bottom_menu_impl.di

import com.evgeny.goncharov.multimodule.bottom_menu_impl.di.contracts.BottomMenuInternal
import com.evgeny.goncharov.multimodule.bottom_menu_impl.di.modules.ViewModelsBottomMenuModule
import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.catalog_api.CatalogLauncher
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.home_api.HomeLauncher
import com.evgeny.goncharov.sample.multimodule.like_api.LikeLauncher
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.authorization_api.AuthorizationLauncher
import com.evgeny.goncharov.sample.multimodule.profile_api.ProfileLauncher
import com.evgeny.goncharov.sample.multimodule.user.di.api.UserApi
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        CoreNavigationApi::class,
        AnalyticsDependencyApi::class,
        UserApi::class
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
            userApi: UserApi,
            @BindsInstance homeLauncher: HomeLauncher,
            @BindsInstance catalogLauncher: CatalogLauncher,
            @BindsInstance authorizationLauncher: AuthorizationLauncher,
            @BindsInstance likeLauncher: LikeLauncher,
            @BindsInstance profileLauncher: ProfileLauncher
        ): BottomMenuComponent
    }
}