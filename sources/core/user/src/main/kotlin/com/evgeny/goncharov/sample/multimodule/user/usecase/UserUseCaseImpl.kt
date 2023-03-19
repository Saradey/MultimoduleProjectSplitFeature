package com.evgeny.goncharov.sample.multimodule.user.usecase

import com.evgeny.goncharov.sample.multimodule.user.analytics.UserAnalytics
import com.evgeny.goncharov.sample.multimodule.user.repository.UserRepository
import javax.inject.Inject

internal class UserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository,
    private val analytics: UserAnalytics
) : UserUseCase {

    override fun isAuthorized(): Boolean {
        return userRepository.isAuthorized()
    }

    override fun signIn() {
        userRepository.updateAuthorized(true)
    }

    override fun signOut() {
        userRepository.updateAuthorized(false)
    }
}