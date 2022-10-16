package com.evgeny.goncharov.sample.multimodule.utils

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi
import com.evgeny.goncharov.sample.multimodule.di_core.holder.BaseHolder
import java.lang.RuntimeException

internal class StubGlobalHolder(container: FeatureContainerManager) :
    BaseHolder<ReleasableApi>(container) {

    override fun buildComponent() = throw RuntimeException("Stub!")
}