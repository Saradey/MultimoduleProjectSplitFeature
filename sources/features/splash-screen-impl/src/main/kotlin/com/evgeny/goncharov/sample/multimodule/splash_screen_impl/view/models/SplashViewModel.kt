package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.view.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuLauncher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class SplashViewModel @Inject constructor(
    private val mainLauncher: BottomMenuLauncher,
    private val analyticsDependencyApi: AnalyticsDependencyApi
) : ViewModel() {



    companion object {

        private const val DELAY = 1500L
    }
}