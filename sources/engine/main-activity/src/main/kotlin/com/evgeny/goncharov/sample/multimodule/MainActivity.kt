package com.evgeny.goncharov.sample.multimodule

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.evgeny.goncharov.sample.multimodule.di.contracts.MainActivityApi
import com.evgeny.goncharov.sample.multimodule.di.contracts.MainActivityInternal
import com.evgeny.goncharov.sample.multimodule.di_core.CoreActivity
import com.evgeny.goncharov.sample.multimodule.navigation.MainActivityNavigator

public class MainActivity : CoreActivity() {

    private val dependency: MainActivityInternal by lazy {
        getFeatureApi(MainActivityApi::class.java) as MainActivityInternal
    }
    private val navigator = MainActivityNavigator(this)
    private val globalNavigatorHolder = dependency.provideGlobalNavigatorHolder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState ?: splashLauncher.launch()
    }

    override fun onResume() {
        super.onResume()
        globalNavigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        globalNavigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun releaseDependency() {
        releaseFeatureApi(MainActivityApi::class.java)
    }
}