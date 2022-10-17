package com.evgeny.goncharov.sample.multimodule.navigation.holder

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.BaseHolder
import com.evgeny.goncharov.sample.multimodule.navigation.DaggerCoreNavigationComponent
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi

public class NavigationHolder(
    featureContainer: FeatureContainerManager
) : BaseHolder<CoreNavigationApi>(featureContainer) {

    override fun buildComponent(): CoreNavigationApi {
        return DaggerCoreNavigationComponent.create()
    }
}