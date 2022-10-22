package com.evgeny.goncharov.sample.multimodule.navigation.base

import androidx.fragment.app.*
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.github.terrakok.cicerone.*
import com.github.terrakok.cicerone.androidx.FragmentScreen

public open class FeatureNavigator(
    protected val containerFragment: ContainerFeatureFragment,
    protected val containerId: Int = com.evgeny.goncharov.sample.multimodule.di_core.R.id.frm_feature_container,
    protected val fragmentManager: FragmentManager = containerFragment.parentFragmentManager,
    protected val fragmentFactory: FragmentFactory = fragmentManager.fragmentFactory
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
        fragmentManager.popBackStack()
        commitNewFragmentScreen(command.screen, true)
    }

    protected open fun back() {
        fragmentManager.popBackStack()
    }

    protected open fun backTo(command: FeatureBackTo) {
        val screenKey = command.screen?.screenKey
        fragmentManager.popBackStack(screenKey, 0)
    }

    protected open fun activityBack() {
        containerFragment.activity?.finish()
    }

    protected open fun commitNewFragmentScreen(
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

    protected open fun setupFragmentTransaction(
        screen: FragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {
        // Do nothing by default
    }

    protected open fun errorOnApplyCommand(
        command: Command, error: RuntimeException
    ) {
        throw error
    }
}