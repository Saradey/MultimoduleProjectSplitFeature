package com.evgeny.goncharov.sample.multimodule.registration_api

import com.evgeny.goncharov.sample.multimodule.di_core.navigation.BaseLauncher

public interface AuthorizationLauncher : BaseLauncher {

    public fun launch()
}