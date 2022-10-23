package com.evgeny.goncharov.sample.multimodule.catalog_impl.di.holder

import com.evgeny.goncharov.sample.multimodule.catalog_api.CatalogApi
import com.evgeny.goncharov.sample.multimodule.catalog_impl.di.DaggerCatalogComponent
import com.evgeny.goncharov.sample.multimodule.di_core.container.FeatureContainer
import com.evgeny.goncharov.sample.multimodule.di_core.holder.FeatureHolder

public class CatalogHolder(container: FeatureContainer) : FeatureHolder<CatalogApi>(container) {

    override fun buildComponent(): CatalogApi {
        return DaggerCatalogComponent.factory()
            .create()
    }
}