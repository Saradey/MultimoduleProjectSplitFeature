package com.evgeny.goncharov.sample.multimodule.navigation.routers

import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalBack
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

    public fun back() {
        executeCommands(GlobalBack)
    }
}