package com.evgeny.goncharov.sample.multimodule.profile_impl.ui

import com.evgeny.goncharov.sample.multimodule.di_core.ContainerFeatureFragment
import com.evgeny.goncharov.sample.multimodule.profile_api.ProfileApi
import com.evgeny.goncharov.sample.multimodule.profile_impl.di.contracts.ProfileInternal
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder

internal class ProfileContainerFragment : ContainerFeatureFragment() {

    private val dependency: ProfileInternal by lazy {
        getFeatureApi(ProfileApi::class.java) as ProfileInternal
    }

    override val navigatorHolder: NavigatorHolder
        get() = TODO("Not yet implemented")
    override val navigator: Navigator
        get() = TODO("Not yet implemented")

    override fun releaseDependencies() {
        releaseFeatureApi(ProfileApi::class.java)
    }
}