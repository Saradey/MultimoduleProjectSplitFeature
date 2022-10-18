package com.evgeny.goncharov.sample.multimodule.navigation.api

import com.evgeny.goncharov.sample.multimodule.navigation.GlobalRouter
import com.github.terrakok.cicerone.NavigatorHolder

public interface CoreNavigationApi {

    public fun provideGlobalRouter(): GlobalRouter

    public fun provideGlobalNavigatorHolder(): NavigatorHolder
}