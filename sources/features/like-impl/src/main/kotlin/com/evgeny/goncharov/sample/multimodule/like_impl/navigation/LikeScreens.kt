package com.evgeny.goncharov.sample.multimodule.like_impl.navigation

import com.evgeny.goncharov.sample.multimodule.like_impl.ui.LikeContainerFragment
import com.evgeny.goncharov.sample.multimodule.like_impl.ui.LikeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object LikeScreens {

    fun startFeature() = FragmentScreen {
        LikeContainerFragment.newInstance()
    }

    fun goToTheLike() = FragmentScreen {
        LikeFragment.newInstance()
    }
}