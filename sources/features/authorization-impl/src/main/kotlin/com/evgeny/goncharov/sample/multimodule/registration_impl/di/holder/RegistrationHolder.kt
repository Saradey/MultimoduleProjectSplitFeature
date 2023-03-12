package com.evgeny.goncharov.sample.multimodule.registration_impl.di.holder

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.registration_api.AuthorizationApi
import com.evgeny.goncharov.sample.multimodule.registration_impl.di.DaggerRegistrationComponent

public class RegistrationHolder(container: FeatureContainer) :
    FeatureHolder<AuthorizationApi>(container) {

    override fun buildComponent(): AuthorizationApi {
        return DaggerRegistrationComponent.factory()
            .create(
                getGlobalComponent(CoreNavigationApi::class.java)
            )
    }
}