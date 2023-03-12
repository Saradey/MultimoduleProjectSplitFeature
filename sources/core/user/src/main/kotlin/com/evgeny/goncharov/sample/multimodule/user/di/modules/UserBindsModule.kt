package com.evgeny.goncharov.sample.multimodule.user.di.modules

import com.evgeny.goncharov.sample.multimodule.di_core.scopes.CoreScope
import com.evgeny.goncharov.sample.multimodule.user.repository.UserRepository
import com.evgeny.goncharov.sample.multimodule.user.repository.UserRepositoryImpl
import com.evgeny.goncharov.sample.multimodule.user.usecase.UserUseCase
import com.evgeny.goncharov.sample.multimodule.user.usecase.UserUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface UserBindsModule {

    @Binds
    @CoreScope
    fun UserUseCaseImpl.bindsUserUseCase(): UserUseCase

    @Binds
    @CoreScope
    fun UserRepositoryImpl.bindsUserRepository(): UserRepository
}