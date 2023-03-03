package com.evgeny.goncharov.multimodule.bottom_menu_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.evgeny.goncharov.multimodule.bottom_menu_impl.R
import com.evgeny.goncharov.multimodule.bottom_menu_impl.ui.BottomMenuContainerFragment
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.navigation.base.BaseNavigator
import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalBack
import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalForward
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.FragmentScreen
import java.util.Stack

internal class BottomMenuNavigator(
    private val fragmentBottomContainer: BottomMenuContainerFragment
) : BaseNavigator() {

    override val fm: FragmentManager = fragmentBottomContainer.childFragmentManager
    override val ff: FragmentFactory = fm.fragmentFactory
    override val containerId: Int = R.id.frm_bottom_menu_feature_container
    private val localBackStack: Stack<String> = Stack()
    private var selectedBackstackMenu = ""

    override fun applyCommand(command: Command) {
        when (command) {
            is GlobalForward -> forward(command)
            is GlobalBack -> back()
        }
    }

    private fun forward(command: GlobalForward) {
        val fragmentScreen = command.screen
        val featureContainerFragment = fragmentScreen.createFragment(ff) as ContainerFeatureFragment
        val backStackName = featureContainerFragment.backStackName
        if (selectedBackstackMenu != backStackName) {
            commitFragmentTransaction(
                fragment = featureContainerFragment,
                fragmentScreen = fragmentScreen,
                addToBackStack = true,
                backStackName = backStackName
            )
            selectedBackstackMenu = backStackName
            if(localBackStack.contains(selectedBackstackMenu)) {
                localBackStack.remove(selectedBackstackMenu)
            }
            localBackStack.push(selectedBackstackMenu)
        }
    }

    override fun commitFragmentTransaction(
        fragment: Fragment,
        fragmentScreen: FragmentScreen,
        addToBackStack: Boolean,
        backStackName: String
    ) {
        if (selectedBackstackMenu.isNotEmpty()) {
            fm.saveBackStack(selectedBackstackMenu)
        }
        if(!localBackStack.contains(backStackName)) {
            fm.commit {
                setReorderingAllowed(true)
                replace(containerId, fragment, fragmentScreen.screenKey)
                addToBackStack(backStackName)
            }
        } else {
            fm.restoreBackStack(backStackName)
        }
    }

    private fun back() {
        if (localBackStack.size > 1) {
            val popBackStackName = localBackStack.pop()
            fm.popBackStack(popBackStackName, 0)
            selectedBackstackMenu = localBackStack.peek()
            fragmentBottomContainer.selectTabBottomMenu(selectedBackstackMenu)
            fm.restoreBackStack(selectedBackstackMenu)
        } else {
            fragmentBottomContainer.requireActivity().finish()
        }
    }
}