package com.evgeny.goncharov.sample.multimodule.user.repository

public interface UserRepository {

    public fun isAuthorized(): Boolean

    public fun updateAuthorized(authorizedStatus: Boolean)
}