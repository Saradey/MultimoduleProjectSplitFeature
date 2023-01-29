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
    }
}