package com.evgeny.goncharov.sample.multimodule.home_impl.di.contracts

import com.evgeny.goncharov.sample.multimodule.home_api.HomeApi
import com.evgeny.goncharov.sample.multimodule.navigation.di.FeatureNavigationContract

internal interface HomeInternal : HomeApi, FeatureNavigationContract