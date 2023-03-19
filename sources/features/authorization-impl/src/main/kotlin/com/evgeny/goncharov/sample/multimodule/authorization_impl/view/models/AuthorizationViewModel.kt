package com.evgeny.goncharov.sample.multimodule.authorization_impl.view.models

import androidx.lifecycle.ViewModel
import com.evgeny.goncharov.sample.multimodule.authorization_impl.analytics.AuthorizationAnalytics
import com.evgeny.goncharov.sample.multimodule.profile_api.ProfileLauncher
import com.evgeny.goncharov.sample.multimodule.user.usecase.UserUseCase
import javax.inject.Inject

internal class AuthorizationViewModel @Inject constructor(
    private val useCase: UserUseCase,
    private val profileLauncher: ProfileLauncher,
    private val analytics: AuthorizationAnalytics
) : ViewModel() {

    fun signIn() {
        useCase.signIn()
        profileLauncher.launchReplace()
        analytics.goToProfile()
    }
}