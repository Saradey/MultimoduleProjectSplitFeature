package com.evgeny.goncharov.sample.multimodule.navigation.di

import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.navigation.routers.FeatureRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
public object FeatureNavigationModule {

    @Provides
    @FeatureScope
    public fun provideFeatureCicerone(): Cicerone<out FeatureRouter> {
        return Cicerone.create(FeatureRouter())
    }

    @Provides
    @FeatureScope
    public fun provideFeatureRouter(cicerone: Cicerone<out FeatureRouter>): FeatureRouter {
        return cicerone.router
    }

    @Provides
    @FeatureScope
    @Named("FeatureNavigatorHolder")
    public fun provideFeatureHolder(cicerone: Cicerone<out FeatureRouter>): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }
}