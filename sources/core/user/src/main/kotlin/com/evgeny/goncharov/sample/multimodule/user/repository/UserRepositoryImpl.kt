package com.evgeny.goncharov.sample.multimodule.user.repository

import android.content.Context
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val applicationContext: Context
) : UserRepository {

    override fun isAuthorized(): Boolean {
        val pref = applicationContext.getSharedPreferences(
            USER_AUTHORIZED_PREF, Context.MODE_PRIVATE
        )
        return pref.getBoolean(USER_AUTHORIZED, false)
    }

    override fun updateAuthorized(authorizedStatus: Boolean) {
        val pref = applicationContext.getSharedPreferences(
            USER_AUTHORIZED_PREF, Context.MODE_PRIVATE
        )
        val editor = pref.edit()
        editor.putBoolean(USER_AUTHORIZED, authorizedStatus)
        editor.apply()
    }

    private companion object {
        const val USER_AUTHORIZED_PREF = "USER_AUTHORIZED_SHARED_PREF"
        const val USER_AUTHORIZED = "USER_AUTHORIZED"
    }
}