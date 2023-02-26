package com.evgeny.goncharov.sample.multimodule.navigation.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.FragmentScreen

public abstract class BaseNavigator : Navigator {

    protected abstract val fm: FragmentManager
    protected abstract val ff: FragmentFactory
    protected abstract val containerId: Int

    public abstract fun applyCommand(command: Command)

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

    protected fun commitFragmentTransaction(
        fragment: Fragment,
        fragmentScreen: FragmentScreen,
        addToBackStack: Boolean,
        backStackName: String
    ) {
        fm.commit {
            setReorderingAllowed(true)
            replace(containerId, fragment, fragmentScreen.screenKey)
            if (addToBackStack) {
                addToBackStack(backStackName)
            }
        }
    }

    private fun errorOnApplyCommand(
        error: RuntimeException
    ) {
        error(
            ERROR_MESSAGE.format(
                this.javaClass.canonicalName,
                TAG,
                error.message
            )
        )
    }

    private companion object {

        const val TAG = "Navigator"
        const val ERROR_MESSAGE =
            "errorOnApplyCommand host: %s tag: %s error message: %s"
    }
}