package com.evgeny.goncharov.multimodule.bottom_menu_impl.di.contracts

import androidx.lifecycle.ViewModelProvider
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuApi

internal interface BottomMenuInternal : BottomMenuApi {

    fun provideViewModelFactory(): ViewModelProvider.Factory
}