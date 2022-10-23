package com.evgeny.goncharov.multimodule.bottom_menu_impl.di

import com.evgeny.goncharov.multimodule.bottom_menu_impl.di.contracts.BottomMenuInternal
import com.evgeny.goncharov.sample.multimodule.navigation.api.CoreNavigationApi
import dagger.Component

@Component(
    dependencies = [CoreNavigationApi::class],
    modules = []
)
internal interface BottomMenuComponent : BottomMenuInternal {

    interface Factory {

        fun create(): BottomMenuComponent
    }
}