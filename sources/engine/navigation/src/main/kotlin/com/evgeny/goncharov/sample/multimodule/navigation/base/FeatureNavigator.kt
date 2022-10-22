package com.evgeny.goncharov.sample.multimodule.navigation.base

import androidx.fragment.app.FragmentManager
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.github.terrakok.cicerone.*
import com.github.terrakok.cicerone.androidx.FragmentScreen

public abstract class FeatureNavigator(
    protected val containerFragment: ContainerFeatureFragment,
    protected val containerId: Int,
    protected val fragmentManager: FragmentManager = containerFragment.parentFragmentManager
) : Navigator {

    override fun applyCommands(commands: Array<out Command>) {
        fragmentManager.executePendingTransactions()
        for (command in commands) {
            try {
                applyCommand(command)
            } catch (e: RuntimeException) {
                errorOnApplyCommand(command, e)
            }
        }
    }

    protected open fun applyCommand(command: Command) {
        when (command) {
            is FeatureForward -> forward(command)
            is FeatureReplace -> replace(command)
            is FeatureBackTo -> backTo(command)
            is FeatureBack -> back()
        }
    }

    protected open fun forward(command: FeatureForward) {
        commitNewFragmentScreen(command.screen, true)
    }

    protected open fun replace(command: FeatureReplace) {

    }

    protected open fun back() {

    }

    protected open fun backTo(command: FeatureBackTo) {

    }

    protected open fun activityBack() {
        containerFragment.activity?.finish()
    }

    protected open fun commitNewFragmentScreen(
        screen: FragmentScreen, addToBackStack: Boolean
    ) {

    }

    protected open fun errorOnApplyCommand(
        command: Command, error: RuntimeException
    ) {
        throw error
    }
}