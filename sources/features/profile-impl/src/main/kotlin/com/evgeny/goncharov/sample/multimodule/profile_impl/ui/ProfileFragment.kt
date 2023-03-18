package com.evgeny.goncharov.sample.multimodule.profile_impl.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.evgeny.goncharov.sample.multimodule.di_core.CoreFragment
import com.evgeny.goncharov.sample.multimodule.profile_api.ProfileApi
import com.evgeny.goncharov.sample.multimodule.profile_impl.R
import com.evgeny.goncharov.sample.multimodule.profile_impl.di.contracts.ProfileInternal
import com.evgeny.goncharov.sample.multimodule.profile_impl.view.models.ProfileViewModel

internal class ProfileFragment : CoreFragment(R.layout.fragment_profile) {

    private val dependency: ProfileInternal by lazy {
        getFeatureApi(ProfileApi::class.java) as ProfileInternal
    }
    private val viewModel: ProfileViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }
}