package com.evgeny.goncharov.sample.multimodule.home_impl.di.holder

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.home_api.HomeApi
import com.evgeny.goncharov.sample.multimodule.home_impl.di.DaggerHomeComponent
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi

public class HomeHolder(container: FeatureContainer) : FeatureHolder<HomeApi>(container) {

    override fun buildComponent(): HomeApi {
        return DaggerHomeComponent.factory()
            .create(
                getGlobalComponent(CoreNavigationApi::class.java)
            )
    }
}