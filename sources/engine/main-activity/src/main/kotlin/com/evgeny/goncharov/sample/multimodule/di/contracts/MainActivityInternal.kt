package com.evgeny.goncharov.sample.multimodule.di.contracts

import androidx.lifecycle.ViewModelProvider
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi

internal interface MainActivityInternal : MainActivityApi, CoreNavigationApi {

    fun provideViewModelFactory(): ViewModelProvider.Factory
}