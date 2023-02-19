package com.evgeny.goncharov.sample.multimodule.navigation

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.evgeny.goncharov.sample.multimodule.R
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.navigation.base.BaseNavigator
import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalBackTo
import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalForward
import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalReplace
import com.github.terrakok.cicerone.androidx.FragmentScreen

public class MainActivityNavigator(
    private val mainActivity: FragmentActivity
) : BaseNavigator() {

    override val fm: FragmentManager = mainActivity.supportFragmentManager
    override val ff: FragmentFactory = fm.fragmentFactory
    override val containerId: Int = R.id.container

    override fun applyCommand(command: Command) {
        when (command) {
            is GlobalForward -> forward(command)
            is GlobalBackTo -> backTo(command)
            is GlobalReplace -> replace(command)
        }
    }

    private fun forward(command: GlobalForward) {
        val fragmentScreen = command.screen
        val featureContainerFragment = fragmentScreen.createFragment(ff) as ContainerFeatureFragment
        commitFragmentTransaction(featureContainerFragment, fragmentScreen, true)
    }

    private fun backTo(command: GlobalBackTo) {
        if (command.screen == null) {
            fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    private fun replace(command: GlobalReplace) {
        val fragmentScreen = command.screen
        val featureContainerFragment = fragmentScreen.createFragment(ff) as ContainerFeatureFragment
        commitFragmentTransaction(featureContainerFragment, fragmentScreen, false)
    }
}