package com.evgeny.goncharov.sample.multimodule.di.contracts

import androidx.lifecycle.ViewModelProvider
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashLauncher

internal interface MainActivityInternal : MainActivityApi, CoreNavigationApi {

    fun provideViewModelFactory(): ViewModelProvider.Factory
}