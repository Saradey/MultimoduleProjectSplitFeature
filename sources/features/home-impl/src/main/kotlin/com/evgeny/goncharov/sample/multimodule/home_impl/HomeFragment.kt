package com.evgeny.goncharov.sample.multimodule.home_impl

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.di_core.CoreFragment

internal class HomeFragment : CoreFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}