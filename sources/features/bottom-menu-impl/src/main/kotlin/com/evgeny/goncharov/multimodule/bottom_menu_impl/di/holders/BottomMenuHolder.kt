package com.evgeny.goncharov.multimodule.bottom_menu_impl.di.holders

import com.evgeny.goncharov.multimodule.bottom_menu_impl.di.DaggerBottomMenuComponent
import com.evgeny.goncharov.sample.multimodule.bottom_menu_api.BottomMenuApi
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder

public class BottomMenuHolder(container: FeatureContainer) :
    FeatureHolder<BottomMenuApi>(container) {

    override fun buildComponent(): BottomMenuApi {
        return DaggerBottomMenuComponent.create()
    }
}