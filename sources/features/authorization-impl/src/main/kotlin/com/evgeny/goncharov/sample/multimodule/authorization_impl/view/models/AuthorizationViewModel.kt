package com.evgeny.goncharov.sample.multimodule.authorization_impl.view.models

import androidx.lifecycle.ViewModel
import com.evgeny.goncharov.sample.multimodule.user.usecase.UserUseCase
import javax.inject.Inject

internal class AuthorizationViewModel @Inject constructor(
    private val useCase: UserUseCase
) : ViewModel() {

    fun signIn() {

    }
}