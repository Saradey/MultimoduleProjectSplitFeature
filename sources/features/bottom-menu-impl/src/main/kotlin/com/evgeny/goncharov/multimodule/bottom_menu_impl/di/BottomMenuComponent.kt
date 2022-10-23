package com.evgeny.goncharov.multimodule.bottom_menu_impl.di

import com.evgeny.goncharov.multimodule.bottom_menu_impl.di.contracts.BottomMenuInternal
import dagger.Component

@Component
internal interface BottomMenuComponent : BottomMenuInternal {

    interface Factory {

        fun create(): BottomMenuComponent
    }
}