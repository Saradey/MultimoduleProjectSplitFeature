package com.evgeny.goncharov.sample.multimodule.authorization_impl.ui

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.di_core.CoreFragment
import com.evgeny.goncharov.sample.multimodule.authorization_impl.R

internal class AuthorizationFragment : CoreFragment(R.layout.fragment_authorization) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    companion object {
        fun newInstance() = AuthorizationFragment()
    }
}