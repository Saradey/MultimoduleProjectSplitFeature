package com.evgeny.goncharov.sample.multimodule.user.di.api

import com.evgeny.goncharov.sample.multimodule.user.usecase.UserUseCase

public interface UserApi {

    public fun provideUserUseCase(): UserUseCase
}