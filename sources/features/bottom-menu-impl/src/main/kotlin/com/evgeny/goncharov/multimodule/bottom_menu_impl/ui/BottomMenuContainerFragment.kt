package com.evgeny.goncharov.multimodule.bottom_menu_impl.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgeny.goncharov.multimodule.bottom_menu_impl.R
import com.evgeny.goncharov.multimodule.bottom_menu_impl.databinding.FragmentBottomMenuBinding
import com.evgeny.goncharov.multimodule.bottom_menu_impl.di.contracts.BottomMenuInternal
import com.evgeny.goncharov.multimodule.bottom_menu_impl.navigation.BottomMenuNavigator
import com.evgeny.goncharov.multimodule.bottom_menu_impl.navigation.BottomMenuNavigator.Companion.BACKSTACK_NAME_CATALOG
import com.evgeny.goncharov.multimodule.bottom_menu_impl.navigation.BottomMenuNavigator.Companion.BACKSTACK_NAME_HOME
import com.evgeny.goncharov.multimodule.bottom_menu_impl.navigation.BottomMenuNavigator.Companion.BACKSTACK_NAME_LIKE
import com.evgeny.goncharov.multimodule.bottom_menu_impl.navigation.BottomMenuNavigator.Companion.BACKSTACK_NAME_PROFILE
import com.evgeny.goncharov.multimodule.bottom_menu_impl.navigation.BottomMenuNavigator.Companion.BACKSTACK_NAME_REG
import com.evgeny.goncharov.multimodule.bottom_menu_impl.view.models.BottomMenuContainerViewModel
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuApi
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.github.terrakok.cicerone.NavigatorHolder

internal class BottomMenuContainerFragment :
    ContainerFeatureFragment(R.layout.fragment_bottom_menu) {

    private val dependency: BottomMenuInternal by lazy {
        getFeatureApi(BottomMenuApi::class.java) as BottomMenuInternal
    }
    private val viewModel: BottomMenuContainerViewModel by viewModels {
        dependency.provideViewModelFactory()
    }
    override val navigator: BottomMenuNavigator by lazy {
        BottomMenuNavigator(this)
    }
    private val onBackPressed = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            viewModel.onBackPressed()
        }
    }
    private val binding: FragmentBottomMenuBinding by viewBinding(FragmentBottomMenuBinding::bind)
    override val navigatorHolder: NavigatorHolder = dependency.provideGlobalNavigatorHolder()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
        savedInstanceState ?: viewModel.startHome()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressed)
    }

    private fun FragmentBottomMenuBinding.initUi() {
        btvMainMenu.setOnItemSelectedListener(::itemBottomMenuClickListener)
    }

    private fun itemBottomMenuClickListener(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> viewModel.goToHome()
            R.id.catalog -> viewModel.goToCatalog()
            R.id.profile -> viewModel.goToProfile()
            R.id.like -> viewModel.goToLike()
        }
        return true
    }

    override fun releaseDependencies() {
        releaseFeatureApi(BottomMenuApi::class.java)
    }

    fun selectTabBottomMenu(selectedBackstackMenu: String) {
        with(binding) {
            btvMainMenu.setOnItemSelectedListener(null)
            when (selectedBackstackMenu) {
                BACKSTACK_NAME_HOME -> binding.btvMainMenu.selectedItemId = R.id.home
                BACKSTACK_NAME_CATALOG -> binding.btvMainMenu.selectedItemId = R.id.catalog
                BACKSTACK_NAME_REG,
                BACKSTACK_NAME_PROFILE -> binding.btvMainMenu.selectedItemId = R.id.profile
                BACKSTACK_NAME_LIKE -> binding.btvMainMenu.selectedItemId = R.id.like
            }
            btvMainMenu.setOnItemSelectedListener(::itemBottomMenuClickListener)
        }
    }

    companion object {

        fun newInstance() = BottomMenuContainerFragment()
    }
}