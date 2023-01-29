package com.evgeny.goncharov.sample.multimodule.navigation.base

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator

public class MainActivityNavigator(
    mainActivity: FragmentActivity,
    private val containerId: Int
) : Navigator {

    private val fm: FragmentManager = mainActivity.supportFragmentManager

    override fun applyCommands(commands: Array<out Command>) {
        fm.executePendingTransactions()
    }
}