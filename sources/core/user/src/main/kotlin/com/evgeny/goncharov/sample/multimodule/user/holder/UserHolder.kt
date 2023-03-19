package com.evgeny.goncharov.sample.multimodule.user.holder

import android.content.Context
import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainerManager
import com.evgeny.goncharov.sample.multimodule.di_core.holder.BaseHolder
import com.evgeny.goncharov.sample.multimodule.user.di.DaggerUserComponent
import com.evgeny.goncharov.sample.multimodule.user.di.api.UserApi

public class UserHolder(
    featureContainer: FeatureContainerManager,
    private val applicationContext: Context
) : BaseHolder<UserApi>(featureContainer) {

    override fun buildComponent(): UserApi {
        return DaggerUserComponent.factory()
            .create(
                getGlobalComponent(AnalyticsDependencyApi::class.java),
                applicationContext
            )
    }
}