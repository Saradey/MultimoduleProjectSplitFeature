package com.evgeny.goncharov.sample.multimodule

import android.os.Bundle
import com.evgeny.goncharov.sample.multimodule.di_core.CoreActivity

public class MainActivity : CoreActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun releaseDependency() {}
}