package com.evgeny.goncharov.sample.multimodule.profile_impl.di

import com.evgeny.goncharov.sample.multimodule.profile_impl.di.contracts.ProfileInternal
import dagger.Component

@Component
internal interface ProfileComponent : ProfileInternal {
}