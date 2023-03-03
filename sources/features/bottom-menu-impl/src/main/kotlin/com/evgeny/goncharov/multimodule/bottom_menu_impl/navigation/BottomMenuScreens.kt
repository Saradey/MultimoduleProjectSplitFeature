package com.evgeny.goncharov.multimodule.bottom_menu_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgeny.goncharov.multimodule.bottom_menu_impl.ui.BottomMenuContainerFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object BottomMenuScreens {

    fun startFeature() = object : FragmentScreen {
        override val screenKey: String = "BottomMenuContainer"

        override fun createFragment(factory: FragmentFactory): Fragment {
            return BottomMenuContainerFragment.newInstance()
        }
    }
}