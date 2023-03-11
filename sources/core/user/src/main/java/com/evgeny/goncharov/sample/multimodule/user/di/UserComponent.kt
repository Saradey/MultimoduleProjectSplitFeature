package com.evgeny.goncharov.sample.multimodule.user.di

import android.content.Context
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.CoreScope
import com.evgeny.goncharov.sample.multimodule.user.di.api.UserApi
import com.evgeny.goncharov.sample.multimodule.user.di.modules.UserBindsModule
import dagger.BindsInstance
import dagger.Component

@CoreScope
@Component(
    modules = [
        UserBindsModule::class
    ]
)
internal interface UserComponent : UserApi {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance applicationContext: Context
        ): UserComponent
    }
}