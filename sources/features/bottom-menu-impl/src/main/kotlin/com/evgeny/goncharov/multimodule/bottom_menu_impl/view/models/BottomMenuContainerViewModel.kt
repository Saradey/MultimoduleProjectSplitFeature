package com.evgeny.goncharov.multimodule.bottom_menu_impl.view.models

import androidx.lifecycle.ViewModel
import javax.inject.Inject

internal class BottomMenuContainerViewModel @Inject constructor() : ViewModel() {

    fun goToHome() {}

    fun goToCatalog() {}

    fun goToProfile() {}

    fun goToLike() {}
}