package com.evgeny.goncharov.sample.multimodule.catalog_impl.ui

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.catalog_api.CatalogApi
import com.evgeny.goncharov.sample.multimodule.catalog_impl.di.contracts.CatalogInternal
import com.evgeny.goncharov.sample.multimodule.catalog_impl.navigation.CatalogScreens
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigator
import com.evgeny.goncharov.sample.multimodule.navigation.routers.FeatureRouter
import com.github.terrakok.cicerone.NavigatorHolder

internal class CatalogContainerFragment : ContainerFeatureFragment() {

    private val dependency: CatalogInternal by lazy {
        getFeatureApi(CatalogApi::class.java) as CatalogInternal
    }
    override val navigator: FeatureNavigator by lazy {
        FeatureNavigator(this)
    }
    override val navigatorHolder: NavigatorHolder = dependency.provideFeatureNavigatorHolder()
    private val router: FeatureRouter = dependency.provideFeatureRouter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        savedInstanceState ?: startFeature()
    }

    private fun startFeature() {
        router.navigateToFeatureScreen(CatalogScreens.goToTheCatalog())
    }

    override fun releaseDependencies() {
        releaseFeatureApi(CatalogApi::class.java)
    }

    companion object {
        fun newInstance() = CatalogContainerFragment()
    }
}