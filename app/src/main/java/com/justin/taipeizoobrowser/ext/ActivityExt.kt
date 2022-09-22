package com.justin.taipeizoobrowser.ext

import android.app.Activity
import com.justin.taipeizoobrowser.TaipeiZooBrowserApplication
import com.justin.taipeizoobrowser.factory.ViewModelFactory

fun Activity.getVmFactory(): ViewModelFactory {
    val repository = (applicationContext as TaipeiZooBrowserApplication).applicationRepository
    return ViewModelFactory(repository)
}