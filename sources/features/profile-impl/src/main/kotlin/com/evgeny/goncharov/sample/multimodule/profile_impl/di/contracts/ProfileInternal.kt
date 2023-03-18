package com.evgeny.goncharov.sample.multimodule.profile_impl.di.contracts

import androidx.lifecycle.ViewModelProvider
import com.evgeny.goncharov.sample.multimodule.navigation.di.FeatureNavigationContract
import com.evgeny.goncharov.sample.multimodule.profile_api.ProfileApi

internal interface ProfileInternal : ProfileApi, FeatureNavigationContract {

    fun provideViewModelFactory(): ViewModelProvider.Factory
}