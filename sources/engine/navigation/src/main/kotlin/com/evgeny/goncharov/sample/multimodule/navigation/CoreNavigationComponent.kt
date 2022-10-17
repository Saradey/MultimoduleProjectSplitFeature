package com.evgeny.goncharov.sample.multimodule.navigation

import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import com.evgeny.goncharov.sample.multimodule.navigation.modules.CoreNavigationModule
import dagger.Component

@Component(
    modules = [CoreNavigationModule::class]
)
internal interface CoreNavigationComponent : CoreNavigationApi