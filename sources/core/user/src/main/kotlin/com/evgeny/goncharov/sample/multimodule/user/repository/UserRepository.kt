package com.evgeny.goncharov.sample.multimodule.user.repository

internal interface UserRepository {

    fun isAuthorized(): Boolean

    fun updateAuthorized(authorizedStatus: Boolean)
}