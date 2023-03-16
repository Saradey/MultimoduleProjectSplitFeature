package com.evgeny.goncharov.sample.multimodule.profile_impl.di.holder

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.profile_api.ProfileApi

public class ProfileHolder(container: FeatureContainer) : FeatureHolder<ProfileApi>(container) {

    override fun buildComponent(): ProfileApi {

    }
}