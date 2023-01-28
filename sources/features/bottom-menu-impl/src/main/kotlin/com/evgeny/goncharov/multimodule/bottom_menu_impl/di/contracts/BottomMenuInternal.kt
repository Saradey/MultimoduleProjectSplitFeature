package com.evgeny.goncharov.multimodule.bottom_menu_impl.di.contracts

import androidx.lifecycle.ViewModelProvider
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuApi
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi

internal interface BottomMenuInternal : BottomMenuApi, CoreNavigationApi {

    fun provideViewModelFactory(): ViewModelProvider.Factory
}