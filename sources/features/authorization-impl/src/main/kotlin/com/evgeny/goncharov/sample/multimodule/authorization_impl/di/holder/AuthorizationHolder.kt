package com.evgeny.goncharov.sample.multimodule.authorization_impl.di.holder

import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.authorization_api.AuthorizationApi
import com.evgeny.goncharov.sample.multimodule.authorization_impl.di.DaggerAuthorizationComponent
import com.evgeny.goncharov.sample.multimodule.profile_api.ProfileLauncher
import com.evgeny.goncharov.sample.multimodule.user.di.api.UserApi

public class AuthorizationHolder(container: FeatureContainer) :
    FeatureHolder<AuthorizationApi>(container) {

    override fun buildComponent(): AuthorizationApi {
        return DaggerAuthorizationComponent.factory()
            .create(
                getGlobalComponent(CoreNavigationApi::class.java),
                getGlobalComponent(UserApi::class.java),
                getGlobalComponent(AnalyticsDependencyApi::class.java),
                getFeatureLauncher(ProfileLauncher::class.java)
            )
    }
}