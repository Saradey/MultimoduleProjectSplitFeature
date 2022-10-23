package com.evgeny.goncharov.multimodule.bottom_menu_impl.navigation

import com.evgeny.goncharov.multimodule.bottom_menu_impl.ui.BottomMenuContainerFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object BottomMenuScreens {

    fun startFeature() = FragmentScreen {
        BottomMenuContainerFragment.newInstance()
    }
}