package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.evgeny.goncharov.sample.multimodule.base_core.MultiViewModelFactory
import com.evgeny.goncharov.sample.multimodule.di_core.key.ViewModelKey
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.view.models.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelsSplashModule {

    @[Binds FeatureScope]
    fun MultiViewModelFactory.provideMultiViewModelFactory(): ViewModelProvider.Factory

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(SplashViewModel::class)]
    fun SplashViewModel.provideSplashViewModel(): ViewModel
}