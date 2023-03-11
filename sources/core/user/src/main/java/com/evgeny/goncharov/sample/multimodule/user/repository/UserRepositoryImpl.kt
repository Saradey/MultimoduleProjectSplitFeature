package com.evgeny.goncharov.sample.multimodule.user.repository

import android.content.Context
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val applicationContext: Context
) : UserRepository {}