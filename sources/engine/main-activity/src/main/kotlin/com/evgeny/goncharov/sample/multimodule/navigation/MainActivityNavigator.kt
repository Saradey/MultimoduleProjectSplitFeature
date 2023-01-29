package com.evgeny.goncharov.sample.multimodule.navigation

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.evgeny.goncharov.sample.multimodule.R
import com.evgeny.goncharov.sample.multimodule.navigation.base.GlobalForward

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
            is GlobalForward -> forwardFeatureContainerFragment(command)
        }
    }

    private fun forwardFeatureContainerFragment(command: GlobalForward) {
        val fragmentScreen = command.screen
        val featureContainerFragment = fragmentScreen.createFragment(ff)
        fm.commit {
            setReorderingAllowed(true)
            replace(R.id.container, featureContainerFragment, fragmentScreen.screenKey)
            addToBackStack(fragmentScreen.screenKey)
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