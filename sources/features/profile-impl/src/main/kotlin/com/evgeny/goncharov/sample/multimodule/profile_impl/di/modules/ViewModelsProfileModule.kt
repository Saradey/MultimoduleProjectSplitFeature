package com.evgeny.goncharov.sample.multimodule.profile_impl.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.evgeny.goncharov.sample.multimodule.di_core.key.ViewModelKey
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.profile_impl.view.models.ProfileViewModel
import com.evgeny.goncharov.sample.multimodule.reusable_sources.MultiViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelsProfileModule {

    @[Binds FeatureScope]
    fun MultiViewModelFactory.provideMultiViewModelFactory(): ViewModelProvider.Factory

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(ProfileViewModel::class)]
    fun ProfileViewModel.provideProfileViewModel(): ViewModel
}