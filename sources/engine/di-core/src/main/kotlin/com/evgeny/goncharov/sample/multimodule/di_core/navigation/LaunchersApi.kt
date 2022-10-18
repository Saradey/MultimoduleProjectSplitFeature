package com.evgeny.goncharov.sample.multimodule.di_core.navigation

public interface LaunchersApi {

    public fun provideLaunchers(): Map<Class<*>, BaseLauncher>
}