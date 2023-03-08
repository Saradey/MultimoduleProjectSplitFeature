package com.evgeny.goncharov.sample.multimodule.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.evgeny.goncharov.sample.multimodule.di_core.key.ViewModelKey
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.reusable_sources.MultiViewModelFactory
import com.evgeny.goncharov.sample.multimodule.view.models.MainActivityViewModel
import dagger.Binds
import dagger.multibindings.IntoMap

internal interface MainActivityViewModelModule {

    @[Binds FeatureScope]
    fun MultiViewModelFactory.provideMultiViewModelFactory(): ViewModelProvider.Factory

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(MainActivityViewModel::class)]
    fun MainActivityViewModel.provideMainActivityViewModel(): ViewModel
}