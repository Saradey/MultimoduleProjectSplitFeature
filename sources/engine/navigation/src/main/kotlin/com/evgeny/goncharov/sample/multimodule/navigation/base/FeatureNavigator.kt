package com.evgeny.goncharov.sample.multimodule.navigation.base

import androidx.fragment.app.*
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.di_core.utils.DiCoreViewId
import com.evgeny.goncharov.sample.multimodule.navigation.commands.InternalForward
import com.github.terrakok.cicerone.*

public class FeatureNavigator(
    private val containerFragment: ContainerFeatureFragment,
) : BaseNavigator() {

    override val fm: FragmentManager = containerFragment.childFragmentManager
    override val ff: FragmentFactory = fm.fragmentFactory
    override val containerId: Int = DiCoreViewId.frm_feature_container

    override fun applyCommand(command: Command) {
        when (command) {
            is InternalForward -> forward(command)
        }
    }

    private fun forward(command: InternalForward) {
        val screen = command.screen
        val fragment = screen.createFragment(ff)
        commitFragmentTransaction(fragment, screen, screen.screenKey)
    }
}