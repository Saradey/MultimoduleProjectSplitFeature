package com.evgeny.goncharov.sample.multimodule.navigation.base

import com.github.terrakok.cicerone.NavigatorHolder
import javax.inject.Named

public interface FeatureNavigationContract {

    public fun provideFeatureRouter(): FeatureRouter

    @Named("GlobalNavigatorHolder")
    public fun provideFeatureNavigatorHolder(): NavigatorHolder
}