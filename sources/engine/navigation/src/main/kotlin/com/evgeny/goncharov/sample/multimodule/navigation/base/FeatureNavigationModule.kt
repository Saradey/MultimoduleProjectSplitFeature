package com.evgeny.goncharov.sample.multimodule.navigation.base

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.Module

@Module
public object FeatureNavigationModule {

    public fun provideFeatureCicerone(): Cicerone<out FeatureRouter> {
        return Cicerone.create(FeatureRouter())
    }

    public fun provideFeatureRouter(cicerone: Cicerone<out FeatureRouter>): FeatureRouter {
        return cicerone.router
    }

    public fun provideFeatureHolder(cicerone: Cicerone<out FeatureRouter>): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }
}