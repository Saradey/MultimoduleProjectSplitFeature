package com.evgeny.goncharov.sample.multimodule.authorization_impl.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgeny.goncharov.sample.multimodule.authorization_api.AuthorizationApi
import com.evgeny.goncharov.sample.multimodule.di_core.CoreFragment
import com.evgeny.goncharov.sample.multimodule.authorization_impl.R
import com.evgeny.goncharov.sample.multimodule.authorization_impl.databinding.FragmentAuthorizationBinding
import com.evgeny.goncharov.sample.multimodule.authorization_impl.di.contracts.AuthorizationInternal
import com.evgeny.goncharov.sample.multimodule.authorization_impl.view.models.AuthorizationViewModel

internal class AuthorizationFragment : CoreFragment(R.layout.fragment_authorization) {

    private val dependency: AuthorizationInternal by lazy {
        getFeatureApi(AuthorizationApi::class.java) as AuthorizationInternal
    }
    private val viewModel: AuthorizationViewModel by viewModels {
        dependency.provideViewModelFactory()
    }
    private val binding: FragmentAuthorizationBinding by viewBinding(FragmentAuthorizationBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initUi()
    }

    private fun FragmentAuthorizationBinding.initUi() {
        btnSignIn.setOnClickListener {
            viewModel.signIn()
        }
    }

    companion object {
        fun newInstance() = AuthorizationFragment()
    }
}