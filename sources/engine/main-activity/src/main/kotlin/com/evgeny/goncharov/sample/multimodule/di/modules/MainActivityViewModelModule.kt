package com.evgeny.goncharov.sample.multimodule.di.modules

import androidx.lifecycle.ViewModelProvider
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.reusable_sources.MultiViewModelFactory
import dagger.Binds

internal interface MainActivityViewModelModule {

    @[Binds FeatureScope]
    fun MultiViewModelFactory.provideMultiViewModelFactory(): ViewModelProvider.Factory

}