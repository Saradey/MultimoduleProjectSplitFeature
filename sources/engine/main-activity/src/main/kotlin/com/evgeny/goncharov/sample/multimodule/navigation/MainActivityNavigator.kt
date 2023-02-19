package com.evgeny.goncharov.sample.multimodule.navigation

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.evgeny.goncharov.sample.multimodule.R
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalBackTo
import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalForward
import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalReplace
import com.github.terrakok.cicerone.androidx.FragmentScreen

public class MainActivityNavigator(
    private val mainActivity: FragmentActivity
) : Navigator {

    private val fm: FragmentManager = mainActivity.supportFragmentManager
    private val ff: FragmentFactory = fm.fragmentFactory

    override fun applyCommands(commands: Array<out Command>) {
        fm.executePendingTransactions()
        for (command in commands) {
            try {
                applyCommand(command)
            } catch (e: RuntimeException) {
                errorOnApplyCommand(e)
            }
        }
    }

    private fun applyCommand(command: Command) {
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

    private fun commitFragmentTransaction(
        featureContainerFragment: ContainerFeatureFragment,
        fragmentScreen: FragmentScreen,
        addToBackStack: Boolean
    ) {
        fm.commit {
            setReorderingAllowed(true)
            replace(R.id.container, featureContainerFragment, fragmentScreen.screenKey)
            if (addToBackStack) {
                addToBackStack(featureContainerFragment.backStackName)
            }
        }
    }

    private fun errorOnApplyCommand(
        error: RuntimeException
    ) {
        error(
            ERROR_MESSAGE.format(
                mainActivity.javaClass.canonicalName,
                TAG,
                error.message
            )
        )
    }

    private companion object {

        const val TAG = "MainActivityNavigator"
        const val ERROR_MESSAGE =
            "errorOnApplyCommand host: %s tag: %s error message: %s"
    }
}