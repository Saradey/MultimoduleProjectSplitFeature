package com.evgeny.goncharov.sample.multimodule.navigation.routers

import com.evgeny.goncharov.sample.multimodule.navigation.commands.InternalForward
import com.github.terrakok.cicerone.BaseRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen

public open class FeatureRouter : BaseRouter() {

    public fun navigateToFeatureScreen(screen: FragmentScreen) {
        executeCommands(InternalForward(screen))
    }
}