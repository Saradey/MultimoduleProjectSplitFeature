package com.evgeny.goncharov.multimodule.bottom_menu_impl.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgeny.goncharov.multimodule.bottom_menu_impl.R
import com.evgeny.goncharov.multimodule.bottom_menu_impl.databinding.FragmentBottomMenuBinding
import com.evgeny.goncharov.multimodule.bottom_menu_impl.di.contracts.BottomMenuInternal
import com.evgeny.goncharov.multimodule.bottom_menu_impl.view.models.BottomMenuContainerViewModel
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuApi
import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigator
import com.github.terrakok.cicerone.NavigatorHolder

internal class BottomMenuContainerFragment :
    ContainerFeatureFragment(R.layout.fragment_bottom_menu) {

    private val dependency: BottomMenuInternal by lazy {
        getFeatureApi(BottomMenuApi::class.java) as BottomMenuInternal
    }

    private val viewModel: BottomMenuContainerViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    private val navigator: FeatureNavigator by lazy {
        FeatureNavigator(
            containerId = R.id.frm_bottom_menu_feature_container,
            containerFragment = this
        )
    }

    private val binding: FragmentBottomMenuBinding by viewBinding(FragmentBottomMenuBinding::bind)
    private val globalNavigator: NavigatorHolder = dependency.provideGlobalNavigatorHolder()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    override fun onResume() {
        super.onResume()
        globalNavigator.setNavigator(navigator)
    }

    override fun onPause() {
        globalNavigator.removeNavigator()
        super.onPause()
    }

    private fun FragmentBottomMenuBinding.initUi() {
        btvMainMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> viewModel.goToHome()
                R.id.catalog -> viewModel.goToCatalog()
                R.id.profile -> viewModel.goToProfile()
                R.id.like -> viewModel.goToLike()
            }
            true
        }
    }

    override fun releaseDependencies() {
        releaseFeatureApi(BottomMenuApi::class.java)
    }

    companion object {
        fun newInstance() = BottomMenuContainerFragment()
    }
}