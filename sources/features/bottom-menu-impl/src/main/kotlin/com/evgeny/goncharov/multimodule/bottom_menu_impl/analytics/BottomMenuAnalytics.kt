package com.evgeny.goncharov.multimodule.bottom_menu_impl.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.manager.AnalyticsManager
import com.evgeny.goncharov.sample.multimodule.analytics.utils.NAVIGATION_EVENT_BACK
import com.evgeny.goncharov.sample.multimodule.analytics.utils.TAG_SCREEN_PARAM
import com.evgeny.goncharov.sample.multimodule.analytics.utils.NAVIGATION_EVENT_KEY
import javax.inject.Inject

internal class BottomMenuAnalytics @Inject constructor(
    private val analyticsManager: AnalyticsManager
) {

    private val params: MutableList<Pair<String, String?>> = mutableListOf<Pair<String, String?>>(
        TAG_SCREEN_PARAM to TAG_SCREEN_BOTTOM_MENU
    )

    private fun prepare() {
        params.clear()
        params.add(TAG_SCREEN_PARAM to TAG_SCREEN_BOTTOM_MENU)
    }

    fun startHome() {
        prepare()
        params.add(NAVIGATION_EVENT_START_HOME to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    fun goToHome() {
        prepare()
        params.add(NAVIGATION_EVENT_GO_TO_HOME to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    fun goToCatalog() {
        prepare()
        params.add(NAVIGATION_EVENT_GO_TO_CATALOG to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    fun goToRegistration() {
        prepare()
        params.add(NAVIGATION_EVENT_GO_TO_REGISTRATION to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    fun goToLike() {
        prepare()
        params.add(NAVIGATION_EVENT_GO_TO_LIKE to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    fun goToProfile() {
        prepare()
        params.add(NAVIGATION_EVENT_GO_TO_PROFILE to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    fun back() {
        prepare()
        params.add(NAVIGATION_EVENT_BACK to null)
        analyticsManager.logEvent(NAVIGATION_EVENT_KEY, params)
    }

    private companion object {
        const val TAG_SCREEN_BOTTOM_MENU = "bottom_menu"
        const val NAVIGATION_EVENT_START_HOME = "bottom_menu_to_start_home"
        const val NAVIGATION_EVENT_GO_TO_HOME = "bottom_menu_go_to_home"
        const val NAVIGATION_EVENT_GO_TO_CATALOG = "bottom_menu_go_to_catalog"
        const val NAVIGATION_EVENT_GO_TO_REGISTRATION = "bottom_menu_go_to_registration"
        const val NAVIGATION_EVENT_GO_TO_LIKE = "bottom_menu_go_to_like"
        const val NAVIGATION_EVENT_GO_TO_PROFILE = "bottom_menu_go_to_profile"
    }
}