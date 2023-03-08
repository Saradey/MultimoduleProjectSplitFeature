package com.evgeny.goncharov.sample.multimodule.di

import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.di.contracts.MainActivityInternal
import com.evgeny.goncharov.sample.multimodule.di.modules.MainActivityViewModelModule
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashLauncher
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        CoreNavigationApi::class,
        AnalyticsDependencyApi::class
    ],
    modules = [MainActivityViewModelModule::class]
)
internal interface MainActivityComponent : MainActivityInternal {

    @Component.Factory
    interface Factory {
        fun create(
            analyticsDependencyApi: AnalyticsDependencyApi,
            coreNavigationApi: CoreNavigationApi,
            @BindsInstance splashScreenLauncher: SplashLauncher
        ): MainActivityComponent
    }
}