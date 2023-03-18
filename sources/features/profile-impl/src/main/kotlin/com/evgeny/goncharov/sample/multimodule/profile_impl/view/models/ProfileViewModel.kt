package com.evgeny.goncharov.sample.multimodule.profile_impl.view.models

import androidx.lifecycle.ViewModel
import com.evgeny.goncharov.sample.multimodule.authorization_api.AuthorizationLauncher
import com.evgeny.goncharov.sample.multimodule.user.usecase.UserUseCase
import javax.inject.Inject

internal class ProfileViewModel @Inject constructor(
    private val authorizationLauncher: AuthorizationLauncher,
    private val userUseCase: UserUseCase
) : ViewModel() {

    fun signOut() {
        userUseCase.signOut()
    }
}