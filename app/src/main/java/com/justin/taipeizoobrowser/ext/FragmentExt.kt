package com.justin.taipeizoobrowser.ext

import androidx.fragment.app.Fragment
import com.justin.taipeizoobrowser.TaipeiZooBrowserApplication
import com.justin.taipeizoobrowser.data.Building
import com.justin.taipeizoobrowser.factory.BuildingViewModelFactory
import com.justin.taipeizoobrowser.factory.ViewModelFactory

fun Fragment.getVmFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as TaipeiZooBrowserApplication).applicationRepository
    return ViewModelFactory(repository)
}

fun Fragment.getVmFactory(building: Building): BuildingViewModelFactory {
    val repository = (requireContext().applicationContext as TaipeiZooBrowserApplication).applicationRepository
    return BuildingViewModelFactory(repository, building)
}