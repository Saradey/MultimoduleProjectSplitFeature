package com.evgeny.goncharov.sample.multimodule.splash_screen_impl.ui

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.di_core.CoreFragment
import com.evgeny.goncharov.sample.multimodule.splash_screen_impl.R

internal class SplashFragment : CoreFragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    companion object {
        fun newInstance() = SplashFragment()
    }
}