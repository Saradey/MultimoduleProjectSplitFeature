package com.evgeny.goncharov.sample.multimodule.navigation.base

import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.FragmentScreen

private interface FeatureCommands : Command

public data class FeatureForward(val screen: FragmentScreen) : FeatureCommands

public data class FeatureReplace(val screen: FragmentScreen) : FeatureCommands

public class FeatureBack : FeatureCommands

public data class FeatureBackTo(val screen: FragmentScreen?) : FeatureCommands