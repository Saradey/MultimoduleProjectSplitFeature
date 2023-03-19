package com.evgeny.goncharov.sample.multimodule.navigation

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.Command
import com.evgeny.goncharov.sample.multimodule.R
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.navigation.base.BaseNavigator
import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalForward
import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalReplace

public class MainActivityNavigator(
    private val mainActivity: FragmentActivity
) : BaseNavigator() {

    override val fm: FragmentManager = mainActivity.supportFragmentManager
    override val ff: FragmentFactory = fm.fragmentFactory
    override val containerId: Int = R.id.container

    override fun applyCommand(command: Command) {
        when (command) {
            is GlobalForward -> forward(command)
            is GlobalReplace -> replace(command)
        }
    }

    private fun forward(command: GlobalForward) {
        val fragmentScreen = command.screen
        val featureContainerFragment = fragmentScreen.createFragment(ff) as ContainerFeatureFragment
        commitFragmentTransaction(
            fragment = featureContainerFragment,
            fragmentScreen = fragmentScreen,
            backStackName = fragmentScreen.screenKey
        )
    }

    private fun replace(command: GlobalReplace) {
        fm.popBackStack()
        val fragmentScreen = command.screen
        val featureContainerFragment = fragmentScreen.createFragment(ff) as ContainerFeatureFragment
        commitFragmentTransaction(
            fragment = featureContainerFragment,
            fragmentScreen = fragmentScreen,
            backStackName = fragmentScreen.screenKey
        )
    }
}