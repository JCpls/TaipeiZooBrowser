package com.justin.taipeizoobrowser.building

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.justin.taipeizoobrowser.data.Building
import com.justin.taipeizoobrowser.data.source.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class BuildingViewModel(
    private val repository: Repository,
    private val arguments: Building
) : ViewModel() {

    private val _building = MutableLiveData<Building>().apply {
        value = arguments
    }

    val building: LiveData<Building>
        get() = _building

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}