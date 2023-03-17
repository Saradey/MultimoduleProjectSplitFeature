package com.evgeny.goncharov.sample.multimodule.authorization_impl.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.evgeny.goncharov.sample.multimodule.authorization_api.AuthorizationApi
import com.evgeny.goncharov.sample.multimodule.di_core.CoreFragment
import com.evgeny.goncharov.sample.multimodule.authorization_impl.R
import com.evgeny.goncharov.sample.multimodule.authorization_impl.di.contracts.AuthorizationInternal
import com.evgeny.goncharov.sample.multimodule.authorization_impl.view.models.AuthorizationViewModel

internal class AuthorizationFragment : CoreFragment(R.layout.fragment_authorization) {

    private val dependency: AuthorizationInternal by lazy {
        getFeatureApi(AuthorizationApi::class.java) as AuthorizationInternal
    }

    private val viewModel: AuthorizationViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    companion object {
        fun newInstance() = AuthorizationFragment()
    }
}