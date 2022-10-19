package com.evgeny.goncharov.sample.multimodule.ui_sandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes

internal class UiSandboxActivity : AppCompatActivity() {

    @IdRes
    private var themeNow: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_sandbox)
    }

    override fun setTheme(@IdRes resId: Int) {
        super.setTheme(resId)
        themeNow = resId
    }
}