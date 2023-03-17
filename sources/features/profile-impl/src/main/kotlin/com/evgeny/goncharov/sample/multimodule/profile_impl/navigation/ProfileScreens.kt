package com.evgeny.goncharov.sample.multimodule.profile_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgeny.goncharov.sample.multimodule.profile_impl.ui.ProfileContainerFragment
import com.evgeny.goncharov.sample.multimodule.profile_impl.ui.ProfileFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object ProfileScreens {

    fun startFeature() = object : FragmentScreen {
        override val screenKey: String = "ProfileContainer"

        override fun createFragment(factory: FragmentFactory): Fragment {
            return ProfileContainerFragment.newInstance()
        }
    }

    fun goToProfile() = FragmentScreen {
        ProfileFragment.newInstance()
    }
}