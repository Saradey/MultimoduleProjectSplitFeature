package com.evgeny.goncharov.sample.multimodule.di.contracts

import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.di_core.navigation.LaunchersApi

internal interface MainActivityInternal : MainActivityApi,
    CoreNavigationApi