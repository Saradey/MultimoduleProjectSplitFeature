package com.evgeny.goncharov.sample.multimodule.registration_impl.navigation

import com.evgeny.goncharov.sample.multimodule.registration_impl.ui.RegistrationContainerFragment
import com.evgeny.goncharov.sample.multimodule.registration_impl.ui.RegistrationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object RegistrationScreens {

    fun startFeature() = FragmentScreen {
        RegistrationContainerFragment.newInstance()
    }

    fun goToTheRegistration() = FragmentScreen {
        RegistrationFragment.newInstance()
    }
}