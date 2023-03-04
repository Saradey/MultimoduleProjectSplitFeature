package com.evgeny.goncharov.sample.multimodule.analytics

import com.evgeny.goncharov.sample.multimodule.di_core.scopes.CoreScope
import dagger.Component

@CoreScope
@Component(modules = [])
internal interface AnalyticsComponent