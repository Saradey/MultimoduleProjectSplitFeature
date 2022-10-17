package com.evgeny.goncharov.sample.multimodule.navigation.api

import com.evgeny.goncharov.sample.multimodule.navigation.GlobalRouter
import com.github.terrakok.cicerone.NavigatorHolder

public interface CoreNavigationApi {

    public fun provideRouter(): GlobalRouter

    public fun provideNavigatorHolder(): NavigatorHolder
}