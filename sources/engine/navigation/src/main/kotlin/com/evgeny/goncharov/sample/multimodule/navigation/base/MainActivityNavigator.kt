package com.evgeny.goncharov.sample.multimodule.navigation.base

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator

public class MainActivityNavigator(
    mainActivity: FragmentActivity,
    private val containerId: Int
) : Navigator {

    private val fm: FragmentManager = mainActivity.supportFragmentManager
    private val ff: FragmentFactory = fm.fragmentFactory

    override fun applyCommands(commands: Array<out Command>) {
        fm.executePendingTransactions()
        for (command in commands) {
            try {
                applyCommand(command)
            } catch (e: RuntimeException) {
                errorOnApplyCommand(command, e)
            }
        }
    }

    private fun applyCommand(command: Command) {
        when (command) {
            is FeatureForward -> forward(command)
        }
    }

    private fun forward(command: FeatureForward) {
        val fragmentScreen = command.screen
        val fragment = fragmentScreen.createFragment(ff)
        fm.commit {
            setReorderingAllowed(true)
        }
    }

    private fun errorOnApplyCommand(
        command: Command,
        error: RuntimeException
    ) {
        throw error(ERROR_MESSAGE.format(TAG, command.toString(), error.message))
    }

    private companion object {

        const val TAG = "MainActivityNavigator"
        const val ERROR_MESSAGE = "errorOnApplyCommand tag: %s command: %s error message: %s"
    }
}