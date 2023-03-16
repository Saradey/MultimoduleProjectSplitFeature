package com.evgeny.goncharov.sample.multimodule.profile_impl.di.contracts

import com.evgeny.goncharov.sample.multimodule.navigation.di.FeatureNavigationContract
import com.evgeny.goncharov.sample.multimodule.profile_api.ProfileApi

internal interface ProfileInternal : ProfileApi, FeatureNavigationContract