package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di.holder

import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuLauncher
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashApi
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di.DaggerSplashComponent

public class SplashHolder(container: FeatureContainer) : FeatureHolder<SplashApi>(container) {

    override fun buildComponent(): SplashApi {
        return DaggerSplashComponent.factory().create(
            getGlobalComponent(CoreNavigationApi::class.java),
            getGlobalComponent(AnalyticsDependencyApi::class.java),
            getFeatureLauncher(BottomMenuLauncher::class.java)
        )
    }
}