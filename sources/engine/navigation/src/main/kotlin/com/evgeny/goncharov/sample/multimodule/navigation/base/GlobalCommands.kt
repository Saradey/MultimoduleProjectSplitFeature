package com.evgeny.goncharov.sample.multimodule.navigation.base

import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.FragmentScreen

private interface GlobalCommands : Command

public data class GlobalForward(val screen: FragmentScreen) : GlobalCommands
