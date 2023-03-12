package com.evgeny.goncharov.sample.multimodule.authorization_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgeny.goncharov.sample.multimodule.authorization_impl.ui.AuthorizationContainerFragment
import com.evgeny.goncharov.sample.multimodule.authorization_impl.ui.AuthorizationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object RegistrationScreens {

    fun startFeature() = object : FragmentScreen {
        override val screenKey: String = "RegistrationContainer"

        override fun createFragment(factory: FragmentFactory): Fragment {
            return AuthorizationContainerFragment.newInstance()
        }
    }

    fun goToTheRegistration() = FragmentScreen {
        AuthorizationFragment.newInstance()
    }
}