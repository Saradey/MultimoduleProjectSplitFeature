package com.evgeny.goncharov.sample.multimodule.like_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgeny.goncharov.sample.multimodule.like_impl.ui.LikeContainerFragment
import com.evgeny.goncharov.sample.multimodule.like_impl.ui.LikeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object LikeScreens {

    fun startFeature() = object : FragmentScreen {
        override val screenKey: String = "LikeContainer"

        override fun createFragment(factory: FragmentFactory): Fragment {
            return LikeContainerFragment.newInstance()
        }
    }

    fun goToTheLike() = FragmentScreen {
        LikeFragment.newInstance()
    }
}