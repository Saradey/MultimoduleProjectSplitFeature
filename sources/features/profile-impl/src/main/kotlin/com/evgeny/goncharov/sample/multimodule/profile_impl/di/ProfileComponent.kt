package com.evgeny.goncharov.sample.multimodule.profile_impl.di

import com.evgeny.goncharov.sample.multimodule.authorization_api.AuthorizationLauncher
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.navigation.di.FeatureNavigationModule
import com.evgeny.goncharov.sample.multimodule.profile_impl.di.contracts.ProfileInternal
import com.evgeny.goncharov.sample.multimodule.profile_impl.di.modules.ViewModelsProfileModule
import com.evgeny.goncharov.sample.multimodule.user.di.api.UserApi
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(
    modules = [
        FeatureNavigationModule::class,
        ViewModelsProfileModule::class
    ],
    dependencies = [
        UserApi::class
    ]
)
internal interface ProfileComponent : ProfileInternal {

    @Component.Factory
    interface Factory {

        fun create(
            userApi: UserApi,
            @BindsInstance authorizationLauncher: AuthorizationLauncher
        ): ProfileComponent
    }
}