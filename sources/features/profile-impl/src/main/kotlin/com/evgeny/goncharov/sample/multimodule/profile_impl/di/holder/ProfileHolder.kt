package com.evgeny.goncharov.sample.multimodule.profile_impl.di.holder

import com.evgeny.goncharov.sample.multimodule.analytics.api.AnalyticsDependencyApi
import com.evgeny.goncharov.sample.multimodule.authorization_api.AuthorizationLauncher
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.profile_api.ProfileApi
import com.evgeny.goncharov.sample.multimodule.profile_impl.di.DaggerProfileComponent
import com.evgeny.goncharov.sample.multimodule.user.di.api.UserApi

public class ProfileHolder(container: FeatureContainer) : FeatureHolder<ProfileApi>(container) {

    override fun buildComponent(): ProfileApi {
        return DaggerProfileComponent.factory()
            .create(
                getGlobalComponent(AnalyticsDependencyApi::class.java),
                getGlobalComponent(UserApi::class.java),
                getFeatureLauncher(AuthorizationLauncher::class.java)
            )
    }
}