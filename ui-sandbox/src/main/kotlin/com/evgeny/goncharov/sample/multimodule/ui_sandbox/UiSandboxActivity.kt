package com.evgeny.goncharov.sample.multimodule.ui_sandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgeny.goncharov.sample.multimodule.ui_sandbox.databinding.ActivityUiSandboxBinding

internal class UiSandboxActivity : AppCompatActivity() {

    @IdRes
    private var themeNow: Int = -1

    private val binding: ActivityUiSandboxBinding by viewBinding(ActivityUiSandboxBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_sandbox)
        binding.initUi()
    }

    private fun ActivityUiSandboxBinding.initUi() {

    }

    override fun setTheme(@IdRes resId: Int) {
        super.setTheme(resId)
        themeNow = resId
    }
}