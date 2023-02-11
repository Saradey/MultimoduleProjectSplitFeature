package com.evgeny.goncharov.sample.multimodule.navigation.base

import androidx.fragment.app.*
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.di_core.utils.DiCoreViewId
import com.github.terrakok.cicerone.*

public class FeatureNavigator(
    private val containerFragment: ContainerFeatureFragment,
    private val containerId: Int = DiCoreViewId.frm_feature_container,
) : Navigator {

    private val fm: FragmentManager = containerFragment.childFragmentManager
    private val ff: FragmentFactory = fm.fragmentFactory
    private val backStackName: String = containerFragment.backStackName
    private val activity: FragmentActivity = containerFragment.requireActivity()

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
            is InternalForward -> forward(command)
            is InternalExit -> exit()
        }
    }

    private fun forward(command: InternalForward) {
        val screen = command.screen
        val fragment = screen.createFragment(ff)
        fm.commit {
            setReorderingAllowed(true)
            replace(containerId, fragment, screen.screenKey)
            addToBackStack(backStackName)
        }
    }

    private fun exit() {
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        activity.onBackPressedDispatcher.onBackPressed()
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