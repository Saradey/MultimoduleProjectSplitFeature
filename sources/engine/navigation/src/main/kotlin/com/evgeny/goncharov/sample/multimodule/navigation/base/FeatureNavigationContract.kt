package com.evgeny.goncharov.sample.multimodule.navigation.base

import com.github.terrakok.cicerone.NavigatorHolder

public interface FeatureNavigationContract {

    public fun provideFeatureRouter(): FeatureRouter

    public fun provideFeatureNavigatorHolder(): NavigatorHolder
}