package com.evgeny.goncharov.sample.multimodule.catalog_impl.ui

import android.os.Bundle
import android.view.View
import com.evgeny.goncharov.sample.multimodule.catalog_impl.R
import com.evgeny.goncharov.sample.multimodule.di_core.CoreFragment

internal class CatalogFragment : CoreFragment(R.layout.fragment_catalog) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    companion object {
        fun newInstance() = CatalogFragment()
    }
}