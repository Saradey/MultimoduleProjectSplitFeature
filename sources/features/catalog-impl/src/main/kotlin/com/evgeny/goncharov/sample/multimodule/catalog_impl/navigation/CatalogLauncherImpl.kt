package com.evgeny.goncharov.sample.multimodule.catalog_impl.navigation

import com.evgeny.goncharov.sample.multimodule.catalog_api.CatalogLauncher
import com.evgeny.goncharov.sample.multimodule.navigation.GlobalRouter

public class CatalogLauncherImpl(
    private val globalRouter: GlobalRouter
) : CatalogLauncher {

    override fun launcher() {
        globalRouter.navigateTo(CatalogScreens.startFeature())
    }
}