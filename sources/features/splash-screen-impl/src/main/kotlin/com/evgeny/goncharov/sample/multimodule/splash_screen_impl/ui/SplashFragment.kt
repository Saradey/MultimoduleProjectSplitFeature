package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.evgeny.goncharov.sample.multimodule.di_core.CoreFragment
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashApi
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.R
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di.contracts.SplashInternal
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.view.models.SplashViewModel
import kotlinx.coroutines.delay

internal class SplashFragment : CoreFragment(R.layout.fragment_splash) {

    private val dependency: SplashInternal by lazy {
        getFeatureApi(SplashApi::class.java) as SplashInternal
    }
    private val viewModel: SplashViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        savedInstanceState ?: lifecycleScope.launchWhenResumed {
            delay(DELAY_START_NEXT_FEATURE)
            viewModel.launchToBottomMenu()
        }
    }

    companion object {
        fun newInstance() = SplashFragment()

        private const val DELAY_START_NEXT_FEATURE = 1000L
    }
}