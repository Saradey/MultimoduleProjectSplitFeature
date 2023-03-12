package com.evgeny.goncharov.sample.multimodule.registration_impl.ui

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.di_core.CoreFragment
import com.evgeny.goncharov.sample.multimodule.registration_impl.R

internal class RegistrationFragment : CoreFragment(R.layout.fragment_registration) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    companion object {
        fun newInstance() = RegistrationFragment()
    }
}