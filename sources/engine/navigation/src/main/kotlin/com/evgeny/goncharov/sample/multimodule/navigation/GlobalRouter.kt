package com.evgeny.goncharov.sample.multimodule.navigation

import com.evgeny.goncharov.sample.multimodule.navigation.base.InternalBackTo
import com.evgeny.goncharov.sample.multimodule.navigation.base.InternalForward
import com.evgeny.goncharov.sample.multimodule.navigation.base.InternalReplace
import com.github.terrakok.cicerone.BaseRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen

public class GlobalRouter : BaseRouter() {

    public fun navigateToFeatureContainer(screen: FragmentScreen) {
        executeCommands(InternalForward(screen))
    }

    public fun newRootScreenFeatureContainer(screen: FragmentScreen) {
        executeCommands(InternalBackTo(null), InternalReplace(screen))
    }
}