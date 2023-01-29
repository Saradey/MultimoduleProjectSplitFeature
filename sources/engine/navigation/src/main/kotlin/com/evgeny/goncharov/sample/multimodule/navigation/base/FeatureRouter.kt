package com.evgeny.goncharov.sample.multimodule.navigation.base

import com.github.terrakok.cicerone.*
import com.github.terrakok.cicerone.androidx.FragmentScreen

public open class FeatureRouter : BaseRouter() {

    public fun navigateToFeatureScreen(screen: FragmentScreen) {
        executeCommands(InternalForward(screen))
    }
}