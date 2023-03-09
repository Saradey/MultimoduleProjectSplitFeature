package com.evgeny.goncharov.sample.multimodule.initializer

import android.app.Application
import android.content.Context
import com.evgeny.goncharov.sample.multimodule.di.components.DaggerGlobalHoldersComponent
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.BaseHolder
import com.evgeny.goncharov.sample.multimodule.di_core.initializer.GlobalHolderInitializer

internal class GlobalHolderInitializerImpl(
    private val app: Application, private val appContext: Context = app
) : GlobalHolderInitializer {

    override fun init(featureContainerManager: FeatureContainerManager): Map<Class<*>, BaseHolder<*>> {
        return DaggerGlobalHoldersComponent.factory().create(
            app,
            appContext,
            featureContainerManager
        ).getGlobalHolders()
    }
}