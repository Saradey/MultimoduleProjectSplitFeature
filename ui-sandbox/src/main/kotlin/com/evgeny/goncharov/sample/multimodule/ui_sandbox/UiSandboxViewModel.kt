package com.evgeny.goncharov.sample.multimodule.ui_sandbox

import androidx.annotation.StyleRes
import androidx.lifecycle.ViewModel
import com.evgeny.goncharov.multimodule.ThemeResourceStyle

internal class UiSandboxViewModel : ViewModel() {

    @StyleRes
    var themeNow: Int = ThemeResourceStyle.AppTheme_Light
}