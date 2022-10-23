package com.evgeny.goncharov.sample.multimodule.like_impl.di.holder

import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder
import com.evgeny.goncharov.sample.multimodule.like_api.LikeApi
import com.evgeny.goncharov.sample.multimodule.like_impl.di.DaggerLikeComponent

public class LikeHolder(container: FeatureContainer) : FeatureHolder<LikeApi>(container) {

    override fun buildComponent(): LikeApi {
        return DaggerLikeComponent.factory()
            .create()
    }
}