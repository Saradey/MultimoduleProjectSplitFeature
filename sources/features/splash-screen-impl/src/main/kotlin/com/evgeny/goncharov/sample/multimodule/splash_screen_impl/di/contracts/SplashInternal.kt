package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di.contracts

import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigationContract
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashApi

internal interface SplashInternal : SplashApi, FeatureNavigationContract {

}