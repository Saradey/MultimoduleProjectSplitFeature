package com.evgeny.goncharov.sample.multimodule.catalog_impl.di

import com.evgeny.goncharov.sample.multimodule.catalog_impl.di.contracts.CatalogInternal
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.FeatureScope
import com.evgeny.goncharov.sample.multimodule.navigation.di.FeatureNavigationModule
import dagger.Component

@FeatureScope
@Component(
    modules = [
        FeatureNavigationModule::class
    ]
)
internal interface CatalogComponent : CatalogInternal {

    @Component.Factory
    interface Factory {

        fun create(): CatalogComponent
    }
}