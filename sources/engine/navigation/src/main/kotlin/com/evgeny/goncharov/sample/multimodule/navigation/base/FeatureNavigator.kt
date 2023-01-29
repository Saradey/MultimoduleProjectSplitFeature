package com.evgeny.goncharov.sample.multimodule.navigation.base

import androidx.fragment.app.*
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.github.terrakok.cicerone.*
import com.github.terrakok.cicerone.androidx.FragmentScreen

public class FeatureNavigator(
    private val containerFragment: ContainerFeatureFragment,
    private val containerId: Int = com.evgeny.goncharov.sample.multimodule.di_core.R.id.frm_feature_container,
    private val fragmentManager: FragmentManager = containerFragment.childFragmentManager,
    private val fragmentFactory: FragmentFactory = fragmentManager.fragmentFactory
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

   private fun applyCommand(command: Command) {
        when (command) {
            is FeatureForward -> forward(command)
            is FeatureReplace -> replace(command)
            is FeatureBackTo -> backTo(command)
            is FeatureBack -> back()
        }
    }

    private fun forward(command: FeatureForward) {
        commitNewFragmentScreen(command.screen, true)
    }

    private fun replace(command: FeatureReplace) {
        fragmentManager.popBackStack()
        commitNewFragmentScreen(command.screen, true)
    }

    private fun back() {
        fragmentManager.popBackStack()
    }

    private fun backTo(command: FeatureBackTo) {
        val screenKey = command.screen?.screenKey
        fragmentManager.popBackStack(screenKey, 0)
    }

    private fun activityBack() {
        containerFragment.activity?.finish()
    }

    private fun commitNewFragmentScreen(
        screen: FragmentScreen, addToBackStack: Boolean
    ) {
        val fragment = screen.createFragment(fragmentFactory)
        fragmentManager.commit {
            setReorderingAllowed(true)
            setupFragmentTransaction(
                screen,
                this,
                fragmentManager.findFragmentById(containerId),
                fragment
            )
            if (screen.clearContainer) {
                replace(containerId, fragment, screen.screenKey)
            } else {
                add(containerId, fragment, screen.screenKey)
            }
            if (addToBackStack) {
                addToBackStack(screen.screenKey)
            }
        }
    }

    private fun setupFragmentTransaction(
        screen: FragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {
        // Do nothing by default
    }

    private fun errorOnApplyCommand(
        command: Command, error: RuntimeException
    ) {
        throw error
    }
}