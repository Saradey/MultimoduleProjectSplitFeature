package com.evgeny.goncharov.sample.multimodule.registration_impl.di.contracts

import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigationContract
import com.evgeny.goncharov.sample.multimodule.registration_api.RegistrationApi

internal interface RegistrationInternal : RegistrationApi, FeatureNavigationContract