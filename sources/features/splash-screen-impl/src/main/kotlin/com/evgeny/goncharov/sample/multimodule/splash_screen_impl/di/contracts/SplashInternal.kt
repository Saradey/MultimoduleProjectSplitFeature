package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di.contracts

import androidx.lifecycle.ViewModelProvider
import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuLauncher
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.navigation.di.FeatureNavigationContract
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashApi

internal interface SplashInternal : SplashApi,
    FeatureNavigationContract,
    CoreNavigationApi {

    fun provideViewModelFactory(): ViewModelProvider.Factory
}