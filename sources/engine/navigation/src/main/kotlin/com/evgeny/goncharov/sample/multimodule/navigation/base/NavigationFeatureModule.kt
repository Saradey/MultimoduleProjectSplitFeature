package com.evgeny.goncharov.sample.multimodule.navigation.base

import com.evgeny.goncharov.sample.multimodule.navigation.GlobalRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder

public interface NavigationFeatureModule {

    public fun provideFeatureCicerone(): Cicerone<out FeatureRouter>

    public fun provideFeatureRouter(cicerone: Cicerone<out FeatureRouter>): FeatureRouter

    public fun provideFeatureHolder(cicerone: Cicerone<GlobalRouter>): NavigatorHolder
}