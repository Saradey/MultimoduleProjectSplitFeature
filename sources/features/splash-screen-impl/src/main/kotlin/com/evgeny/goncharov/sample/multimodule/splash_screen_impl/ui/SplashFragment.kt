package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuLauncher
import com.evgeny.goncharov.sample.multimodule.di_core.CoreFragment
import com.evgeny.goncharov.sample.multimodule.splash_screen_api.SplashApi
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.R
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.di.contracts.SplashInternal
import kotlinx.coroutines.delay

internal class SplashFragment : CoreFragment(R.layout.fragment_splash) {

    private val dependency: SplashInternal by lazy {
        getFeatureApi(SplashApi::class.java) as SplashInternal
    }
    private val mainLauncher: BottomMenuLauncher = dependency.provideMainLauncher()
//    private val viewModel: SplashViewModel by viewModels {
//        dependency.provideViewModelFactory()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launchWhenResumed {
            delay(DELAY_START_NEXT_FEATURE)
            mainLauncher.launch()
        }
    }

    companion object {
        fun newInstance() = SplashFragment()

        private const val DELAY_START_NEXT_FEATURE = 1000L
    }
}