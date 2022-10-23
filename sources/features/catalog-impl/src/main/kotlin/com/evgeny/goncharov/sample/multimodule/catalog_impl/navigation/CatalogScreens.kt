package com.evgeny.goncharov.sample.multimodule.catalog_impl.navigation

import com.evgeny.goncharov.sample.multimodule.catalog_impl.ui.CatalogContainerFragment
import com.evgeny.goncharov.sample.multimodule.catalog_impl.ui.CatalogFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object CatalogScreens {

    fun startFeature() = FragmentScreen {
        CatalogContainerFragment.newInstance()
    }

    fun goToTheCatalog() = FragmentScreen {
        CatalogFragment.newInstance()
    }
}