package com.evgeny.goncharov.sample.multimodule.registration_impl.navigation

import com.evgeny.goncharov.sample.multimodule.navigation.GlobalRouter
import com.evgeny.goncharov.sample.multimodule.registration_api.RegistrationLauncher

public class RegistrationLauncherImpl(
    private val globalRouter: GlobalRouter
) : RegistrationLauncher {

    override fun launch() {
        globalRouter.startNewFeatureOnTopCurrentFeature(RegistrationScreens.startFeature())
    }
}