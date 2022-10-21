package com.evgeny.goncharov.sample.multimodule.navigation.base

import com.github.terrakok.cicerone.Cicerone

public interface NavigationFeatureModule {

    public fun provideFeatureCicerone(): Cicerone<out FeatureRouter>

    public fun provideFeatureRouter(cicerone: Cicerone<out FeatureRouter>): FeatureRouter

    public fun provideFeatureHolder(cicerone: Cicerone<out FeatureRouter>): FeatureNavigator
}