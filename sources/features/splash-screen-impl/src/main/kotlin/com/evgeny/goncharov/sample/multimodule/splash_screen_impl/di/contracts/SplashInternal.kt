package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di.contracts

import androidx.lifecycle.ViewModelProvider
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigationContract
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashApi

internal interface SplashInternal : SplashApi, FeatureNavigationContract {

    fun provideViewModelFactory(): ViewModelProvider.Factory
}