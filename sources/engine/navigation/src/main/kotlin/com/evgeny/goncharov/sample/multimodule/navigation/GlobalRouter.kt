package com.evgeny.goncharov.sample.multimodule.navigation

import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalBackTo
import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalForward
import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalReplace
import com.github.terrakok.cicerone.BaseRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen

public class GlobalRouter : BaseRouter() {

    public fun navigateToFeatureContainer(screen: FragmentScreen) {
        executeCommands(GlobalForward(screen))
    }

    public fun replaceFeatureContainerScreen(screen: FragmentScreen) {
        executeCommands(GlobalReplace(screen))
    }

    public fun newRootScreenFeatureContainer(screen: FragmentScreen) {
        executeCommands(GlobalBackTo(null), GlobalReplace(screen))
    }
}