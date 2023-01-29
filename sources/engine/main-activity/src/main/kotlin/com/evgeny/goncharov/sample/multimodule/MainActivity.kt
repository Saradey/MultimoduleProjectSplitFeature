package com.evgeny.goncharov.sample.multimodule

import android.os.Bundle
import com.evgeny.goncharov.sample.multimodule.di.contracts.MainActivityApi
import com.evgeny.goncharov.sample.multimodule.di.contracts.MainActivityInternal
import com.evgeny.goncharov.sample.multimodule.di_core.CoreActivity
import com.evgeny.goncharov.sample.multimodule.navigation.base.ActivityNavigator

public class MainActivity : CoreActivity() {

    private val dependency: MainActivityInternal by lazy {
        getFeatureApi(MainActivityApi::class.java) as MainActivityInternal
    }
    private val navigator = ActivityNavigator(this, R.id.container)
    private val navigatorHolder = dependency.provideGlobalNavigatorHolder()
    private val splashLauncher = dependency.provideSplashLauncher()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState ?: splashLauncher.launch()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun releaseDependency() {
        releaseFeatureApi(MainActivityApi::class.java)
    }
}