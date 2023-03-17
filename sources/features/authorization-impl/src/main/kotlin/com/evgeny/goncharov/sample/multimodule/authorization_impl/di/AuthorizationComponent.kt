package com.evgeny.goncharov.sample.multimodule.authorization_impl.di

import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.authorization_impl.di.contracts.AuthorizationInternal
import com.evgeny.goncharov.sample.multimodule.authorization_impl.di.modules.ViewModelsAuthorizationModule
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.navigation.di.FeatureNavigationModule
import com.evgeny.goncharov.sample.multimodule.profile_api.ProfileLauncher
import com.evgeny.goncharov.sample.multimodule.user.di.api.UserApi
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(
    modules = [
        FeatureNavigationModule::class,
        ViewModelsAuthorizationModule::class
    ],
    dependencies = [
        CoreNavigationApi::class,
        UserApi::class
    ]
)
internal interface AuthorizationComponent : AuthorizationInternal {

    @Component.Factory
    interface Factory {
        fun create(
            coreNavigationApi: CoreNavigationApi,
            userApi: UserApi,
            @BindsInstance profileLauncher: ProfileLauncher
        ): AuthorizationComponent
    }
}