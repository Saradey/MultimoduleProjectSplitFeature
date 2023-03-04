package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.analytics

import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.analytics.utils.TAG_SCREEN_PARAM
import javax.inject.Inject

internal class SplashAnalytics @Inject constructor(
    private val analyticsDependencyApi: AnalyticsDependencyApi
) {

    private val params = mutableListOf<Pair<String, String>>(
        TAG_SCREEN_PARAM to ""
    )

    fun goToTheBottomMainMenu() {

    }

    private companion object {
    }

}