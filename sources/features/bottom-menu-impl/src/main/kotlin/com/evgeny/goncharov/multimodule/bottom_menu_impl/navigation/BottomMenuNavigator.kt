package com.evgeny.goncharov.multimodule.bottom_menu_impl.navigation

import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import com.evgeny.goncharov.multimodule.bottom_menu_impl.R
import com.evgeny.goncharov.multimodule.bottom_menu_impl.ui.BottomMenuContainerFragment
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.navigation.base.BaseNavigator
import com.evgeny.goncharov.sample.multimodule.navigation.commands.GlobalForward
import com.github.terrakok.cicerone.Command

internal class BottomMenuNavigator(
    private val fragmentBottomContainer: BottomMenuContainerFragment
) : BaseNavigator() {

    override val fm: FragmentManager = fragmentBottomContainer.childFragmentManager
    override val ff: FragmentFactory = fm.fragmentFactory
    override val containerId: Int = R.id.frm_bottom_menu_feature_container
    private var selectedBackstackMenu = ""

    override fun applyCommand(command: Command) {
        when (command) {
            is GlobalForward -> forward(command)
        }
    }

    private fun forward(command: GlobalForward) {
        val fragmentScreen = command.screen
        val featureContainerFragment = fragmentScreen.createFragment(ff) as ContainerFeatureFragment
        if (selectedBackstackMenu != featureContainerFragment.backStackName) {
            commitFragmentTransaction(
                fragment = featureContainerFragment,
                fragmentScreen = fragmentScreen,
                addToBackStack = true,
                backStackName = featureContainerFragment.backStackName
            )
            selectedBackstackMenu = featureContainerFragment.backStackName
        }
    }
}