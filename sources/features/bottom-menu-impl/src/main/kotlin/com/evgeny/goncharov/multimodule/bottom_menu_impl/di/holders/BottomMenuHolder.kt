package com.evgeny.goncharov.multimodule.bottom_menu_impl.di.holders

import com.evgeny.goncharov.multimodule.bottom_menu_impl.di.DaggerBottomMenuComponent
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuApi
import com.evgeny.goncharov.sample.multimodule.catalog_api.CatalogLauncher
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.home_api.HomeLauncher
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi

public class BottomMenuHolder(container: FeatureContainer) :
    FeatureHolder<BottomMenuApi>(container) {

    override fun buildComponent(): BottomMenuApi {
        return DaggerBottomMenuComponent.factory()
            .create(
                getGlobalComponent(CoreNavigationApi::class.java),
                getFeatureLauncher(HomeLauncher::class.java),
                getFeatureLauncher(CatalogLauncher::class.java)
            )
    }
}