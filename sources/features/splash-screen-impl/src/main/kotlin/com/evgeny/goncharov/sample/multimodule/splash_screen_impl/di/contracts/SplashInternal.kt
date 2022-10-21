package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di.contracts

import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashApi

internal interface SplashInternal :
    SplashApi,
    CoreNavigationApi {
}