package com.evgeny.goncharov.sample.multimodule.navigation.base

import androidx.fragment.app.*
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.github.terrakok.cicerone.*

public class FeatureNavigator(
    private val containerFragment: ContainerFeatureFragment,
    private val containerId: Int = com.evgeny.goncharov.sample.multimodule.di_core.R.id.frm_feature_container,
) : Navigator {

    private val fm: FragmentManager = containerFragment.childFragmentManager
    private val ff: FragmentFactory = fm.fragmentFactory


    override fun applyCommands(commands: Array<out Command>) {
        fm.executePendingTransactions()
    }

    private fun errorOnApplyCommand(
        error: RuntimeException
    ) {
        error(
            ERROR_MESSAGE.format(
                containerFragment.javaClass.canonicalName,
                TAG,
                error.message
            )
        )
    }

    private companion object {

        const val TAG = "FeatureNavigator"
        const val ERROR_MESSAGE =
            "errorOnApplyCommand host: %s tag: %s error message: %s"
    }
}