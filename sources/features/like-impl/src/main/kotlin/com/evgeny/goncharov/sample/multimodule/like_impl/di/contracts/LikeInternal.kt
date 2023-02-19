package com.evgeny.goncharov.sample.multimodule.like_impl.di.contracts

import com.evgeny.goncharov.sample.multimodule.like_api.LikeApi
import com.evgeny.goncharov.sample.multimodule.navigation.di.FeatureNavigationContract

internal interface LikeInternal : LikeApi, FeatureNavigationContract