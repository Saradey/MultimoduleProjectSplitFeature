package com.evgeny.goncharov.sample.multimodule.di

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder

public class MainActivityHolder(container: FeatureContainerManager) :
    FeatureHolder<MainActivityApi>(container) {

    override fun buildComponent(): MainActivityApi {
        TODO("Not yet implemented")
    }
}