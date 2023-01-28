package com.evgeny.goncharov.sample.multimodule.catalog_impl.di.contracts

import com.evgeny.goncharov.sample.multimodule.catalog_api.CatalogApi
import com.evgeny.goncharov.sample.multimodule.navigation.base.FeatureNavigationContract

internal interface CatalogInternal : CatalogApi, FeatureNavigationContract