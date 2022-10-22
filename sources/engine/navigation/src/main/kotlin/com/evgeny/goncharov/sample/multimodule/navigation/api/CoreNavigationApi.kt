package com.evgeny.goncharov.sample.multimodule.navigation.api

import com.evgeny.goncharov.sample.multimodule.navigation.GlobalRouter
import com.github.terrakok.cicerone.NavigatorHolder
import javax.inject.Named

public interface CoreNavigationApi {

    public fun provideGlobalRouter(): GlobalRouter

    @Named("GlobalNavigatorHolder")
    public fun provideGlobalNavigatorHolder(): NavigatorHolder
}