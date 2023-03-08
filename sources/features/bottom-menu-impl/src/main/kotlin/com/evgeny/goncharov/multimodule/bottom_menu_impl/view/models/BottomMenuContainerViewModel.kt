package com.evgeny.goncharov.multimodule.bottom_menu_impl.view.models

import androidx.lifecycle.ViewModel
import com.evgeny.goncharov.multimodule.bottom_menu_impl.analytics.BottomMenuAnalytics
import com.evgeny.goncharov.sample.multimodule.catalog_api.CatalogLauncher
import com.evgeny.goncharov.sample.multimodule.home_api.HomeLauncher
import com.evgeny.goncharov.sample.multimodule.like_api.LikeLauncher
import com.evgeny.goncharov.sample.multimodule.navigation.routers.GlobalRouter
import com.evgeny.goncharov.sample.multimodule.registration_api.RegistrationLauncher
import javax.inject.Inject

internal class BottomMenuContainerViewModel @Inject constructor(
    private val homeLauncher: HomeLauncher,
    private val catalogLauncher: CatalogLauncher,
    private val registrationLauncher: RegistrationLauncher,
    private val likeLauncher: LikeLauncher,
    private val globalRouter: GlobalRouter,
    private val analytics: BottomMenuAnalytics
) : ViewModel() {

    fun startHome() {
        homeLauncher.launch()
        analytics.startHome()
    }

    fun goToHome() {
        homeLauncher.launch()
        analytics.goToHome()
    }

    fun goToCatalog() {
        catalogLauncher.launch()
    }

    fun goToProfile() {
        //TODO логика с авторизацией
        registrationLauncher.launch()
    }

    fun goToLike() {
        likeLauncher.launch()
    }

    fun onBackPressed() {
        globalRouter.back()
    }
}