package com.evgeny.goncharov.sample.multimodule.navigation.api

import com.evgeny.goncharov.sample.multimodule.navigation.contracts.BaseLauncher

public interface LaunchersApi {

    public fun provideLaunchers(): Map<Class<*>, BaseLauncher>
}