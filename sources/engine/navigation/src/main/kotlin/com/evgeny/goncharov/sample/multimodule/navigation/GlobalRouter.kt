package com.evgeny.goncharov.sample.multimodule.navigation

import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureBackTo
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureForward
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureReplace
import com.github.terrakok.cicerone.BaseRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen

public class GlobalRouter : BaseRouter() {

    public fun startNewFeatureOnTopCurrentFeature(screen: FragmentScreen) {
        executeCommands(FeatureForward(screen))
    }

    public fun startFeatureReplaceCurrentFeature(screen: FragmentScreen) {
        executeCommands(FeatureBackTo(null), FeatureReplace(screen))
    }
}