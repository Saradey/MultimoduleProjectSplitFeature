package com.evgeny.goncharov.sample.multimodule.di.holder

import com.evgeny.goncharov.sample.multimodule.di.DaggerMainActivityComponent
import com.evgeny.goncharov.sample.multimodule.di.contracts.MainActivityApi
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashLauncher

public class MainActivityHolder(container: FeatureContainer) :
    FeatureHolder<MainActivityApi>(container) {

    override fun buildComponent(): MainActivityApi {
        return DaggerMainActivityComponent.factory()
            .create(
                getGlobalComponent(CoreNavigationApi::class.java),
                getFeatureLauncher(SplashLauncher::class.java)
            )
    }
}