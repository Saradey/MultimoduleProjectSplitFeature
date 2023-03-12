package com.evgeny.goncharov.sample.multimodule.registration_impl.di.holder

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.authorization_api.AuthorizationApi

public class RegistrationHolder(container: FeatureContainer) :
    FeatureHolder<AuthorizationApi>(container) {

    override fun buildComponent(): AuthorizationApi {
        return DaggerAuthorizationComponent.factory()
            .create(
                getGlobalComponent(CoreNavigationApi::class.java)
            )
    }
}