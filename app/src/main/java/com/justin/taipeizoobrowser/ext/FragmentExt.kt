package com.justin.taipeizoobrowser.ext

import androidx.fragment.app.Fragment
import com.justin.taipeizoobrowser.TaipeiZooBrowserApplication
import com.justin.taipeizoobrowser.factory.ViewModelFactory

fun Fragment.getVmFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as TaipeiZooBrowserApplication).applicationRepository
    return ViewModelFactory(repository)
}