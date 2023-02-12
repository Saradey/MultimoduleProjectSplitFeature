package com.evgeny.goncharov.sample.multimodule.navigation

import com.evgeny.goncharov.sample.multimodule.navigation.base.GlobalBackTo
import com.evgeny.goncharov.sample.multimodule.navigation.base.GlobalForward
import com.evgeny.goncharov.sample.multimodule.navigation.base.GlobalReplace
import com.github.terrakok.cicerone.BaseRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen

public class GlobalRouter : BaseRouter() {

    public fun navigateToFeatureContainer(screen: FragmentScreen) {
        executeCommands(GlobalForward(screen))
    }

    public fun newRootScreenFeatureContainer(screen: FragmentScreen) {
        executeCommands(GlobalBackTo(null), GlobalReplace(screen))
    }
}