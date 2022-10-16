package com.evgeny.goncharov.sample.multimodule.di_core.initializer

import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder

public interface FeatureHolderInitializer {

    public fun init(): Map<Class<*>, FeatureHolder<*>>
}