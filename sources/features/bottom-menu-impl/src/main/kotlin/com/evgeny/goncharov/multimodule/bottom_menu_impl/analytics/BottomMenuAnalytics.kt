package com.evgeny.goncharov.multimodule.bottom_menu_impl.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.utils.TAG_SCREEN_PARAM
import com.evgeny.goncharov.sample.multimodule.analytics.utils.UI_EVENT_KEY_NAVIGATION
import javax.inject.Inject

internal class BottomMenuAnalytics @Inject constructor(
    private val analyticsDependencyApi: AnalyticsManager
) {

    private val params: MutableList<Pair<String, String?>>
        get() = mutableListOf<Pair<String, String?>>(
            TAG_SCREEN_PARAM to TAG_BOTTOM_MENU_PARAM
        )

    fun startHome() {
        params.add(UI_EVENT_START_HOME to null)
        analyticsDependencyApi.logEvent(UI_EVENT_KEY_NAVIGATION, params)
    }

    fun goToTheHome() {
        params.add(UI_EVENT_GO_TO_HOME to null)
        analyticsDependencyApi.logEvent(UI_EVENT_KEY_NAVIGATION, params)
    }

    fun goToTheCatalog() {
        params.add(UI_EVENT_GO_TO_HOME to null)
        analyticsDependencyApi.logEvent(UI_EVENT_GO_TO_CATALOG, params)
    }

    fun goToRegistration() {

    }

    fun goToTheLike() {

    }

    fun goToProfile() {

    }

    private companion object {
        const val TAG_BOTTOM_MENU_PARAM = "bottom_menu"
        const val UI_EVENT_START_HOME = "bottom_menu_to_start_home"
        const val UI_EVENT_GO_TO_HOME = "bottom_menu_go_to_home"
        const val UI_EVENT_GO_TO_CATALOG = "bottom_menu_go_to_catalog"
    }
}