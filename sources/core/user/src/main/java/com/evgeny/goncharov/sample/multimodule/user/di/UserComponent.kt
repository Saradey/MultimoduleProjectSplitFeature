package com.evgeny.goncharov.sample.multimodule.user.di

import android.content.Context
import com.evgeny.goncharov.sample.multimodule.di_core.scopes.CoreScope
import com.evgeny.goncharov.sample.multimodule.user.di.api.UserApi
import dagger.BindsInstance
import dagger.Component

@CoreScope
@Component
internal interface UserComponent : UserApi {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance applicationContext: Context
        ): UserComponent
    }
}