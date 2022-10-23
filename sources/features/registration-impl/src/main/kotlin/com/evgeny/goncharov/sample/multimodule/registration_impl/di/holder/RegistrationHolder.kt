package com.evgeny.goncharov.sample.multimodule.registration_impl.di.holder

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.registration_api.RegistrationApi
import com.evgeny.goncharov.sample.multimodule.registration_impl.di.DaggerRegistrationComponent

public class RegistrationHolder(container: FeatureContainer) :
    FeatureHolder<RegistrationApi>(container) {

    override fun buildComponent(): RegistrationApi {
        return DaggerRegistrationComponent.factory()
            .create(
                getGlobalComponent(CoreNavigationApi::class.java)
            )
    }
}