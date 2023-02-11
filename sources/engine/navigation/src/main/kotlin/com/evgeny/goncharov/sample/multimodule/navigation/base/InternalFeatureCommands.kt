package com.evgeny.goncharov.sample.multimodule.navigation.base

import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.FragmentScreen

private interface InternalFeatureCommands : Command

public data class InternalForward(val screen: FragmentScreen) : InternalFeatureCommands

public data class InternalReplace(val screen: FragmentScreen) : InternalFeatureCommands

public class InternalBack : InternalFeatureCommands

public class InternalExitFeature : InternalFeatureCommands

public data class InternalBackTo(val screen: FragmentScreen?) : InternalFeatureCommands