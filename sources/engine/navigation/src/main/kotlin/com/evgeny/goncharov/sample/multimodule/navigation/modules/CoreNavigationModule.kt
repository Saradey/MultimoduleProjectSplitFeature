package com.evgeny.goncharov.sample.multimodule.navigation.modules

import com.evgeny.goncharov.sample.multimodule.di_core.scopes.CoreScope
import com.evgeny.goncharov.sample.multimodule.navigation.GlobalRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.Module
import dagger.Provides

@Module
internal object CoreNavigationModule {

    @[CoreScope Provides]
    fun provideCicerone(): Cicerone<GlobalRouter> = Cicerone.create(GlobalRouter())

    @[CoreScope Provides]
    fun provideRouter(cicerone: Cicerone<GlobalRouter>): GlobalRouter = cicerone.router

    @[CoreScope Provides]
    fun provideHolder(cicerone: Cicerone<GlobalRouter>): NavigatorHolder =
        cicerone.getNavigatorHolder()
}