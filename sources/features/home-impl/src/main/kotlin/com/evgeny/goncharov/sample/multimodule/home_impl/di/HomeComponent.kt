package com.evgeny.goncharov.sample.multimodule.home_impl.di

import com.evgeny.goncharov.sample.multimodule.home_impl.di.contracts.HomeInternal
import dagger.Component


@Component
internal interface HomeComponent : HomeInternal {

    @Component.Factory
    interface Factory {
        fun create(): HomeComponent
    }
}