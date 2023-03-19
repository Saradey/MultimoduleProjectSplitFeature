package com.evgeny.goncharov.multimodule.bottom_menu_impl.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.utils.TAG_SCREEN_PARAM
import com.evgeny.goncharov.sample.multimodule.analytics.utils.NAVIGATION_EVENT_KEY
import javax.inject.Inject

internal class BottomMenuAnalytics @Inject constructor(
    private val analyticsManager: AnalyticsManager
) {

    private val params: MutableList<Pair<String, String?>> = mutableListOf<Pair<String, String?>>(
        TAG_SCREEN_PARAM to TAG_BOTTOM_MENU_PARAM
    )

    private fun prepare() {
        params.clear()
        params.add(TAG_SCREEN_PARAM to TAG_BOTTOM_MENU_PARAM)
    }

    fun startHome() {
        prepare()
        params.add(UI_EVENT_START_HOME to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    fun goToHome() {
        prepare()
        params.add(UI_EVENT_GO_TO_HOME to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    fun goToCatalog() {
        prepare()
        params.add(UI_EVENT_GO_TO_CATALOG to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    fun goToRegistration() {
        prepare()
        params.add(UI_EVENT_GO_TO_REGISTRATION to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    fun goToLike() {
        prepare()
        params.add(UI_EVENT_GO_TO_LIKE to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    fun goToProfile() {
        prepare()
        params.add(UI_EVENT_GO_TO_PROFILE to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    fun back() {
        prepare()
        params.add(UI_EVENT_GO_BACK to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    private companion object {
        const val TAG_BOTTOM_MENU_PARAM = "bottom_menu"
        const val UI_EVENT_START_HOME = "bottom_menu_to_start_home"
        const val UI_EVENT_GO_TO_HOME = "bottom_menu_go_to_home"
        const val UI_EVENT_GO_TO_CATALOG = "bottom_menu_go_to_catalog"
        const val UI_EVENT_GO_TO_REGISTRATION = "bottom_menu_go_to_registration"
        const val UI_EVENT_GO_TO_LIKE = "bottom_menu_go_to_like"
        const val UI_EVENT_GO_TO_PROFILE = "bottom_menu_go_to_profile"
        const val UI_EVENT_GO_BACK = "bottom_menu_back"
    }
}