package com.evgeny.goncharov.sample.multimodule

import android.os.Bundle
import androidx.activity.viewModels
import com.evgeny.goncharov.sample.multimodule.di.contracts.MainActivityApi
import com.evgeny.goncharov.sample.multimodule.di.contracts.MainActivityInternal
import com.evgeny.goncharov.sample.multimodule.di_core.CoreActivity
import com.evgeny.goncharov.sample.multimodule.navigation.MainActivityNavigator
import com.evgeny.goncharov.sample.multimodule.view.models.MainActivityViewModel

public class MainActivity : CoreActivity() {

    private val dependency: MainActivityInternal by lazy {
        getFeatureApi(MainActivityApi::class.java) as MainActivityInternal
    }
    private val navigator = MainActivityNavigator(this)
    private val globalNavigatorHolder = dependency.provideGlobalNavigatorHolder()
    private val viewModel: MainActivityViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState ?: {
            viewModel.startApplication()
            viewModel.startSplash()
        }
    }

    override fun onResume() {
        super.onResume()
        globalNavigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        globalNavigatorHolder.removeNavigator()
        if (isFinishing) {
            viewModel.sendEventAnalyticsFinisApplication()
        }
        super.onPause()
    }

    override fun releaseDependency() {
        releaseFeatureApi(MainActivityApi::class.java)
    }
}