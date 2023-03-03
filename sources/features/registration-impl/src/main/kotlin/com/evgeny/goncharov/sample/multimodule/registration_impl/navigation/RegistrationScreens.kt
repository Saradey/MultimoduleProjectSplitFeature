package com.evgeny.goncharov.sample.multimodule.registration_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.evgeny.goncharov.sample.multimodule.registration_impl.ui.RegistrationContainerFragment
import com.evgeny.goncharov.sample.multimodule.registration_impl.ui.RegistrationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object RegistrationScreens {

    fun startFeature() = object : FragmentScreen {
        override val screenKey: String = "RegistrationContainer"

        override fun createFragment(factory: FragmentFactory): Fragment {
            return RegistrationContainerFragment.newInstance()
        }
    }

    fun goToTheRegistration() = FragmentScreen {
        RegistrationFragment.newInstance()
    }
}