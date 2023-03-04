package com.evgeny.goncharov.multimodule.bottom_menu_impl.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.evgeny.goncharov.multimodule.bottom_menu_impl.view.models.BottomMenuContainerViewModel
import com.evgeny.goncharov.sample.multimodule.reusable_sources.MultiViewModelFactory
import com.evgeny.goncharov.sample.multimodule.di_core.key.ViewModelKey
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelsBottomMenuModule {

    @[Binds FeatureScope]
    fun MultiViewModelFactory.provideMultiViewModelFactory(): ViewModelProvider.Factory

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(BottomMenuContainerViewModel::class)]
    fun BottomMenuContainerViewModel.provideBottomMenuContainerViewModel(): ViewModel
}