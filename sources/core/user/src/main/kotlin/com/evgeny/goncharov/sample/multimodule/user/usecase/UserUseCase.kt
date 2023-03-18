package com.evgeny.goncharov.sample.multimodule.user.usecase

public interface UserUseCase {

    public fun isAuthorized(): Boolean

    public fun signIn()

    public fun signOut()
}