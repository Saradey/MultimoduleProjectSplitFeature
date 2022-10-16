package com.evgeny.goncharov.sample.multimodule.di_core.container

import com.evgeny.goncharov.sample.multimodule.di_core.contracts.ReleasableApi
import com.evgeny.goncharov.sample.multimodule.di_core.holder.BaseHolder
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.di_core.initializer.FeatureHolderInitializer
import com.evgeny.goncharov.sample.multimodule.di_core.initializer.GlobalHolderInitializer

public class FeatureContainerImpl(
    private val globalHolder: MutableMap<Class<*>, BaseHolder<*>> = HashMap(),
    private val featureHolder: MutableMap<Class<ReleasableApi>, FeatureHolder<ReleasableApi>> = HashMap(),
) : FeatureContainerManager {

    private var featureInitializer: FeatureHolderInitializer? = null

    override fun getFeatureComponent(key: Class<out ReleasableApi>): ReleasableApi {
        return getFeatureHolder(key).getComponent()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <D> getGlobalComponent(key: Class<D>): D {
        return globalHolder[key]?.getComponent() as D
            ?: throw IllegalStateException(String.format(FAILED_GET_GLOBAL_HOLDER, key))
    }

    override fun releaseFeatureComponent(key: Class<out ReleasableApi>) {
        featureHolder[key]?.releaseFeature() ?: throw IllegalStateException(
            String.format(
                FAILED_RELEASE_HOLDER,
                key
            )
        )
    }

    override fun init(
        globalInitializer: GlobalHolderInitializer,
        featureInitializer: FeatureHolderInitializer
    ): FeatureContainerManager {
        globalHolder.putAll(globalInitializer.init())
        this.featureInitializer = featureInitializer
        return this
    }

    private fun getFeatureHolder(key: Class<out ReleasableApi>): FeatureHolder<out ReleasableApi> {
        if (featureHolder.isEmpty()) {
            initAllFeatureHolder()
        }
        return featureHolder[key]
            ?: throw IllegalStateException(String.format(FAILED_GET_HOLDER, key))
    }

    @Suppress("UNCHECKED_CAST")
    private fun initAllFeatureHolder() {
        featureInitializer?.let { initializer ->
            featureHolder.putAll(
                initializer.init() as Map<Class<ReleasableApi>, FeatureHolder<ReleasableApi>>
            )
        }
    }

    private companion object {
        private const val FAILED_GET_HOLDER = "failed get feature holder %s"

        private const val FAILED_RELEASE_HOLDER = "failed release feature holder %s"

        private const val FAILED_GET_GLOBAL_HOLDER = "failed get global holder %s"
    }
}