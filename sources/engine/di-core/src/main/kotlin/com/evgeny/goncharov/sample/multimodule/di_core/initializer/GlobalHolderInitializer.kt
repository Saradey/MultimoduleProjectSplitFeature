package com.evgeny.goncharov.sample.multimodule.di_core.initializer

import com.evgeny.goncharov.sample.multimodule.di_core.holder.BaseHolder

public interface GlobalHolderInitializer {

    public fun init(): Map<Class<*>, BaseHolder<*>>
}