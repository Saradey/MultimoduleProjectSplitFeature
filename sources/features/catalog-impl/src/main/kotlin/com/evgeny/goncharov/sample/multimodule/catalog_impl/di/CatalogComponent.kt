package com.evgeny.goncharov.sample.multimodule.catalog_impl.di

import com.evgeny.goncharov.sample.multimodule.catalog_impl.di.contracts.CatalogInternal
import dagger.Component

@Component
internal interface CatalogComponent : CatalogInternal {

    @Component.Factory
    interface Factory {

        fun create(): CatalogComponent
    }
}