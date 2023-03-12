package com.evgeny.goncharov.sample.multimodule.registration_impl.di.contracts

import com.evgeny.goncharov.sample.multimodule.navigation.di.FeatureNavigationContract
import com.evgeny.goncharov.sample.multimodule.authorization_api.AuthorizationApi

internal interface AuthorizationInternal : AuthorizationApi, FeatureNavigationContract