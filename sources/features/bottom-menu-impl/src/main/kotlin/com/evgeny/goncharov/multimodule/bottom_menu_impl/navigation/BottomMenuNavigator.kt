package com.evgeny.goncharov.multimodule.bottom_menu_impl.navigation

import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.evgeny.goncharov.multimodule.bottom_menu_impl.R
import com.evgeny.goncharov.multimodule.bottom_menu_impl.ui.BottomMenuContainerFragment
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalForward
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal class BottomMenuNavigator(
    private val fragmentBottomContainer: BottomMenuContainerFragment
) : Navigator {

    private val fm: FragmentManager = fragmentBottomContainer.childFragmentManager
    private val ff: FragmentFactory = fm.fragmentFactory
    private val idContainer: Int = R.id.frm_bottom_menu_feature_container
    private var selectedBackstackMenu = ""

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
        }
    }

    private fun forward(command: GlobalForward) {
        val fragmentScreen = command.screen
        val featureContainerFragment = fragmentScreen.createFragment(ff) as ContainerFeatureFragment
        if (selectedBackstackMenu != featureContainerFragment.backStackName) {
            commitFragmentTransaction(featureContainerFragment, fragmentScreen)
        }
    }

    private fun commitFragmentTransaction(
        featureContainerFragment: ContainerFeatureFragment,
        fragmentScreen: FragmentScreen,
    ) {
        fm.commit {
            setReorderingAllowed(true)
            replace(idContainer, featureContainerFragment, fragmentScreen.screenKey)
            addToBackStack(featureContainerFragment.backStackName)
            selectedBackstackMenu = featureContainerFragment.backStackName
        }
    }

    private fun errorOnApplyCommand(
        error: RuntimeException
    ) {
        error(
            ERROR_MESSAGE.format(
                fragmentBottomContainer.javaClass.canonicalName,
                TAG,
                error.message
            )
        )
    }

    private companion object {

        const val TAG = "BottomMenuContainerFragment"
        const val ERROR_MESSAGE =
            "errorOnApplyCommand host: %s tag: %s error message: %s"
    }
}