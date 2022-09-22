package com.justin.taipeizoobrowser.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.justin.taipeizoobrowser.building.BuildingViewModel
import com.justin.taipeizoobrowser.data.Building
import com.justin.taipeizoobrowser.data.source.Repository

@Suppress("UNCHECKED_CAST")
class BuildingViewModelFactory constructor(
    private val repository: Repository,
    private val building: Building
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(BuildingViewModel::class.java) ->
                    BuildingViewModel(repository, building)

                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}