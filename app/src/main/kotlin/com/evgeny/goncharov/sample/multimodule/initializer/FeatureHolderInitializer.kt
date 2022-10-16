package com.evgeny.goncharov.sample.multimodule.initializer

import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.di_core.initializer.HolderInitializer

internal object FeatureHolderInitializer : HolderInitializer {

    override fun init(): Map<Class<*>, FeatureHolder<*>> {
        return hashMapOf()
    }
}