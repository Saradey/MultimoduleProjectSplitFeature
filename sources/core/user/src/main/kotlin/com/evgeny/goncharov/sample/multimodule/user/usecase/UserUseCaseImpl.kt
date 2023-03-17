package com.evgeny.goncharov.sample.multimodule.user.usecase

import com.evgeny.goncharov.sample.multimodule.user.repository.UserRepository
import javax.inject.Inject

internal class UserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : UserUseCase {

    override fun isAuthorized(): Boolean {
        return userRepository.isAuthorized()
    }

    override fun signIn() {
        userRepository.updateAuthorized(true)
    }
}