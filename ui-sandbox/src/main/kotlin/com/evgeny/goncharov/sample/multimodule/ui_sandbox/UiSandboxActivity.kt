package com.evgeny.goncharov.sample.multimodule.ui_sandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgeny.goncharov.sample.multimodule.ui_sandbox.databinding.ActivityUiSandboxBinding

internal class UiSandboxActivity : AppCompatActivity() {

    private val binding: ActivityUiSandboxBinding by viewBinding(ActivityUiSandboxBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(themeNow)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_sandbox)
        binding.initUi()
    }

    private fun ActivityUiSandboxBinding.initUi() {
//        btnOnLightTheme.setOnClickListener {
//            if (themeNow != com.evgeny.goncharov.multimodule.R.style.AppTheme_Light) {
//                themeNow = com.evgeny.goncharov.multimodule.R.style.AppTheme_Light
//                recreate()
//            }
//        }
//        btnOnDarkTheme.setOnClickListener {
//            if (themeNow != com.evgeny.goncharov.multimodule.R.style.AppTheme_Night) {
//                themeNow = com.evgeny.goncharov.multimodule.R.style.AppTheme_Night
//                recreate()
//            }
//        }
    }
}