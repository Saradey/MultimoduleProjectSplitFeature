package com.evgeny.goncharov.sample.multimodule.ui_sandbox

import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel

internal class UiSandboxViewModel : ViewModel() {

    @IdRes
    var themeNow: Int = com.evgeny.goncharov.multimodule.R.style.AppTheme_Light


}