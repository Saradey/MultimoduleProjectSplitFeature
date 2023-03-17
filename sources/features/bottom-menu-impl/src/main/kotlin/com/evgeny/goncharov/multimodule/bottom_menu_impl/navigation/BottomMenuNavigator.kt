package com.evgeny.goncharov.multimodule.bottom_menu_impl.navigation

import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.evgeny.goncharov.multimodule.bottom_menu_impl.R
import com.evgeny.goncharov.multimodule.bottom_menu_impl.ui.BottomMenuContainerFragment
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
        val backStackName = fragmentScreen.screenKey
        if (selectedBackstackMenu != backStackName) {
            commit(
                fragmentScreen = fragmentScreen,
                backStackName = backStackName
            )
            selectedBackstackMenu = backStackName
            if (localBackStack.contains(selectedBackstackMenu)) {
                localBackStack.remove(selectedBackstackMenu)
            }
            localBackStack.push(selectedBackstackMenu)
        }
    }

    private fun commit(
        fragmentScreen: FragmentScreen,
        backStackName: String
    ) {
        if (selectedBackstackMenu.isNotEmpty()) {
            fm.saveBackStack(selectedBackstackMenu)
        }
        if (!localBackStack.contains(backStackName)) {
            val featureContainerFragment = fragmentScreen.createFragment(ff)
            fm.commit {
                setReorderingAllowed(true)
                replace(containerId, featureContainerFragment, fragmentScreen.screenKey)
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

    companion object {
        const val BACKSTACK_NAME_HOME = "HomeContainer"
        const val BACKSTACK_NAME_CATALOG = "CatalogContainer"
        const val BACKSTACK_NAME_REG = "AuthorizationContainer"
        const val BACKSTACK_NAME_PROFILE = "ProfileContainer"
        const val BACKSTACK_NAME_LIKE = "LikeContainer"
    }
}