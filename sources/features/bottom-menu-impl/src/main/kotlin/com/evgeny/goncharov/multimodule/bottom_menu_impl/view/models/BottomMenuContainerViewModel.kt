package com.evgeny.goncharov.multimodule.bottom_menu_impl.view.models

import androidx.lifecycle.ViewModel
import com.evgeny.goncharov.sample.multimodule.catalog_api.CatalogLauncher
import com.evgeny.goncharov.sample.multimodule.home_api.HomeLauncher
import javax.inject.Inject

internal class BottomMenuContainerViewModel @Inject constructor(
    private val homeLauncher: HomeLauncher,
    private val catalogLauncher: CatalogLauncher
) : ViewModel() {

    fun goToHome() {
        homeLauncher.launch()
    }

    fun goToCatalog() {
        catalogLauncher.launch()
    }

    fun goToProfile() {}

    fun goToLike() {}
}