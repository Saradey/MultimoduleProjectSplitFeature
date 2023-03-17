package com.evgeny.goncharov.sample.multimodule.authorization_impl.di.contracts

import androidx.lifecycle.ViewModelProvider
import com.evgeny.goncharov.sample.multimodule.navigation.di.FeatureNavigationContract
import com.evgeny.goncharov.sample.multimodule.authorization_api.AuthorizationApi

internal interface AuthorizationInternal : AuthorizationApi, FeatureNavigationContract{

    fun provideViewModelFactory(): ViewModelProvider.Factory
}