package com.evgeny.goncharov.multimodule.bottom_menu_impl.di.holders

import com.evgeny.goncharov.multimodule.bottom_menu_impl.di.DaggerBottomMenuComponent
import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuApi
import com.evgeny.goncharov.sample.multimodule.catalog_api.CatalogLauncher
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.home_api.HomeLauncher
import com.evgeny.goncharov.sample.multimodule.like_api.LikeLauncher
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.registration_api.RegistrationLauncher

public class BottomMenuHolder(container: FeatureContainer) :
    FeatureHolder<BottomMenuApi>(container) {

    override fun buildComponent(): BottomMenuApi {
        return DaggerBottomMenuComponent.factory()
            .create(
                getGlobalComponent(CoreNavigationApi::class.java),
                getGlobalComponent(AnalyticsDependencyApi::class.java),
                getFeatureLauncher(HomeLauncher::class.java),
                getFeatureLauncher(CatalogLauncher::class.java),
                getFeatureLauncher(RegistrationLauncher::class.java),
                getFeatureLauncher(LikeLauncher::class.java)
            )
    }
}