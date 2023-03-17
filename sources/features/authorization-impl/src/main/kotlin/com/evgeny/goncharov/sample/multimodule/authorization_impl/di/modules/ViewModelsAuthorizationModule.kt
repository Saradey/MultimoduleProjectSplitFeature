package com.evgeny.goncharov.sample.multimodule.authorization_impl.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.evgeny.goncharov.sample.multimodule.authorization_impl.view.models.AuthorizationViewModel
import com.evgeny.goncharov.sample.multimodule.di_core.key.ViewModelKey
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.reusable_sources.MultiViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelsAuthorizationModule {

    @[Binds FeatureScope]
    fun MultiViewModelFactory.provideMultiViewModelFactory(): ViewModelProvider.Factory

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(AuthorizationViewModel::class)]
    fun AuthorizationViewModel.provideAuthorizationViewModel(): ViewModel
}