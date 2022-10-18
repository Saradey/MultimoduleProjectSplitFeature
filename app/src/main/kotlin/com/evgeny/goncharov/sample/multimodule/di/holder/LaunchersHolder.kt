package com.evgeny.goncharov.sample.multimodule.di.holder

import com.evgeny.goncharov.sample.multimodule.di.components.DaggerLaunchersComponent
import com.evgeny.goncharov.sample.multimodule.di.components.LaunchersComponent
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.BaseHolder
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi

internal class LaunchersHolder(
    container: FeatureContainerManager
) : BaseHolder<LaunchersComponent>(container) {

    override fun buildComponent(): LaunchersComponent {
        return DaggerLaunchersComponent.builder()
            .coreNavigationApi(getGlobalComponent(CoreNavigationApi::class.java))
            .build()
    }
}