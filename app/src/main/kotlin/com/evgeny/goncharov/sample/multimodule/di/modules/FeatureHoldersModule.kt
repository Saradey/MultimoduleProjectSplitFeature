package com.evgeny.goncharov.sample.multimodule.di.modules

import com.evgeny.goncharov.multimodule.bottom_menu_impl.di.holders.BottomMenuHolder
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuApi
import com.evgeny.goncharov.sample.multimodule.catalog_api.CatalogApi
import com.evgeny.goncharov.sample.multimodule.catalog_impl.di.holder.CatalogHolder
import com.evgeny.goncharov.sample.multimodule.di.contracts.MainActivityApi
import com.evgeny.goncharov.sample.multimodule.di.holder.MainActivityHolder
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.home_api.HomeApi
import com.evgeny.goncharov.sample.multimodule.home_impl.di.holder.HomeHolder
import com.evgeny.goncharov.sample.multimodule.like_api.LikeApi
import com.evgeny.goncharov.sample.multimodule.like_impl.di.holder.LikeHolder
import com.evgeny.goncharov.sample.multimodule.authorization_api.AuthorizationApi
import com.evgeny.goncharov.sample.multimodule.registration_impl.di.holder.AuthorizationHolder
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashApi
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di.holder.SplashHolder
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
internal object FeatureHoldersModule {

    @[Singleton Provides]
    @[IntoMap ClassKey(MainActivityApi::class)]
    fun provideMainActivityHolder(featureContainer: FeatureContainer): FeatureHolder<*> =
        MainActivityHolder(featureContainer)

    @[Singleton Provides]
    @[IntoMap ClassKey(SplashApi::class)]
    fun provideSplashHolder(featureContainer: FeatureContainer): FeatureHolder<*> =
        SplashHolder(featureContainer)

    @[Singleton Provides]
    @[IntoMap ClassKey(BottomMenuApi::class)]
    fun provideBottomMenuHolder(featureContainer: FeatureContainer): FeatureHolder<*> =
        BottomMenuHolder(featureContainer)

    @[Singleton Provides]
    @[IntoMap ClassKey(HomeApi::class)]
    fun provideHomeHolder(featureContainer: FeatureContainer): FeatureHolder<*> =
        HomeHolder(featureContainer)

    @[Singleton Provides]
    @[IntoMap ClassKey(CatalogApi::class)]
    fun provideCatalogHolder(featureContainer: FeatureContainer): FeatureHolder<*> =
        CatalogHolder(featureContainer)

    @[Singleton Provides]
    @[IntoMap ClassKey(AuthorizationApi::class)]
    fun provideRegistrationHolder(featureContainer: FeatureContainer): FeatureHolder<*> =
        AuthorizationHolder(featureContainer)

    @[Singleton Provides]
    @[IntoMap ClassKey(LikeApi::class)]
    fun provideLikeHolder(featureContainer: FeatureContainer): FeatureHolder<*> =
        LikeHolder(featureContainer)
}