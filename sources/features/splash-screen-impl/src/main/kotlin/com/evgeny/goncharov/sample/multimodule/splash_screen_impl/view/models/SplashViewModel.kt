package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.view.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class SplashViewModel @Inject constructor(

) : ViewModel() {

    fun startTime() {
        viewModelScope.launch {
            delay(DELAY)
        }
    }

    companion object {

        private const val DELAY = 1500L
    }
}