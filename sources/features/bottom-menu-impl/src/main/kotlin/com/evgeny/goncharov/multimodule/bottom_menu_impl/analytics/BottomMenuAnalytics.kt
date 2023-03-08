package com.evgeny.goncharov.multimodule.bottom_menu_impl.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.utils.TAG_SCREEN_PARAM
import javax.inject.Inject

internal class BottomMenuAnalytics @Inject constructor(
    private val analyticsDependencyApi: AnalyticsManager
) {

    private val params = mutableListOf<Pair<String, String?>>(
        TAG_SCREEN_PARAM to TAG_BOTTOM_MENU_PARAM
    )

    fun startHome() {

    }

    fun goToTheHome() {

    }

    fun goToTheCatalog() {

    }

    fun goToRegistration() {

    }

    fun goToTheLike() {

    }

    fun goToProfile() {

    }

    private companion object {
        const val TAG_BOTTOM_MENU_PARAM = "bottom_menu"
    }
}