package com.evgeny.goncharov.sample.multimodule.like_impl.ui

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.di_core.CoreFragment
import com.evgeny.goncharov.sample.multimodule.like_impl.R

internal class LikeFragment : CoreFragment(R.layout.fragment_like) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    companion object {
        fun newInstance() = LikeFragment()
    }
}