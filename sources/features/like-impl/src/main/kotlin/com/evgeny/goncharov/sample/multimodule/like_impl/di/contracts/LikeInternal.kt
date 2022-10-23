package com.evgeny.goncharov.sample.multimodule.like_impl.di.contracts

import com.evgeny.goncharov.sample.multimodule.like_api.LikeApi
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigationContract

internal interface LikeInternal : LikeApi, FeatureNavigationContract