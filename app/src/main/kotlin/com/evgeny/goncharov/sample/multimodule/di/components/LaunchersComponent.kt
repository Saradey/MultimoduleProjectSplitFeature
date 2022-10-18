package com.evgeny.goncharov.sample.multimodule.di.components

import com.evgeny.goncharov.sample.multimodule.di.modules.LauncherModule
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.navigation.api.LaunchersApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [CoreNavigationApi::class],
    modules = [LauncherModule::class]
)
internal interface LaunchersComponent : LaunchersApi