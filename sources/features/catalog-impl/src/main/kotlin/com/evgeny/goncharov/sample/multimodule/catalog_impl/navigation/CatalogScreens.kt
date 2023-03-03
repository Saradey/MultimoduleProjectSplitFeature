package com.evgeny.goncharov.sample.multimodule.catalog_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgeny.goncharov.sample.multimodule.catalog_impl.ui.CatalogContainerFragment
import com.evgeny.goncharov.sample.multimodule.catalog_impl.ui.CatalogFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object CatalogScreens {

    fun startFeature() = object : FragmentScreen {
        override val screenKey: String = "CatalogContainer"

        override fun createFragment(factory: FragmentFactory): Fragment {
            return CatalogContainerFragment.newInstance()
        }
    }

    fun goToTheCatalog() = FragmentScreen {
        CatalogFragment.newInstance()
    }
}