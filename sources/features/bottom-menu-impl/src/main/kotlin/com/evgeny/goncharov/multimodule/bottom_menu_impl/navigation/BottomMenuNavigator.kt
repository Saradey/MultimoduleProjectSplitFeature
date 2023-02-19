package com.evgeny.goncharov.multimodule.bottom_menu_impl.navigation

import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import com.evgeny.goncharov.multimodule.bottom_menu_impl.ui.BottomMenuContainerFragment
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator

internal class BottomMenuNavigator(
    private val fragmentBottomContainer: BottomMenuContainerFragment
) : Navigator {

    private val fm: FragmentManager = fragmentBottomContainer.childFragmentManager
    private val fc: FragmentFactory = fm.fragmentFactory

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