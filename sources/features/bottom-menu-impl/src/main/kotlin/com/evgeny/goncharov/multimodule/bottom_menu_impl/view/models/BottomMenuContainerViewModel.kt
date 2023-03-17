package com.evgeny.goncharov.multimodule.bottom_menu_impl.view.models

import androidx.lifecycle.ViewModel
import com.evgeny.goncharov.multimodule.bottom_menu_impl.analytics.BottomMenuAnalytics
import com.evgeny.goncharov.sample.multimodule.catalog_api.CatalogLauncher
import com.evgeny.goncharov.sample.multimodule.home_api.HomeLauncher
import com.evgeny.goncharov.sample.multimodule.like_api.LikeLauncher
import com.evgeny.goncharov.sample.multimodule.navigation.routers.GlobalRouter
import com.evgeny.goncharov.sample.multimodule.authorization_api.AuthorizationLauncher
import com.evgeny.goncharov.sample.multimodule.profile_api.ProfileLauncher
import com.evgeny.goncharov.sample.multimodule.user.usecase.UserUseCase
import javax.inject.Inject

internal class BottomMenuContainerViewModel @Inject constructor(
    private val homeLauncher: HomeLauncher,
    private val catalogLauncher: CatalogLauncher,
    private val authorizationLauncher: AuthorizationLauncher,
    private val likeLauncher: LikeLauncher,
    private val globalRouter: GlobalRouter,
    private val analytics: BottomMenuAnalytics,
    private val userUseCase: UserUseCase,
    private val profileLauncher: ProfileLauncher
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
        analytics.goToCatalog()
    }

    fun goToProfile() {
        if(userUseCase.isAuthorized()) {
            profileLauncher.launch()
            analytics.goToProfile()
        } else {
            authorizationLauncher.launch()
            analytics.goToRegistration()
        }
    }

    fun goToLike() {
        likeLauncher.launch()
        analytics.goToLike()
    }

    fun onBackPressed() {
        globalRouter.back()
        analytics.back()
    }
}