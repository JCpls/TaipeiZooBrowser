package com.justin.taipeizoobrowser.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.justin.taipeizoobrowser.data.Building
import com.justin.taipeizoobrowser.data.HomeItem
import com.justin.taipeizoobrowser.data.Result
import com.justin.taipeizoobrowser.data.source.Repository
import kotlinx.coroutines.*

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private val _homeItems = MutableLiveData<List<HomeItem>?>()

    val homeItems: LiveData<List<HomeItem>?>
        get() = _homeItems

    private val _navigateToBuildingDetail = MutableLiveData<Building?>()

    val navigateToBuildingDetail: LiveData<Building?>
        get() = _navigateToBuildingDetail


    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        getBuildingsResult()
    }

    private fun getBuildingsResult() {
        coroutineScope.launch(Dispatchers.IO) {

            when (val result = repository.getBuildings()) {
                is Result.Success -> {
                    result.data.let { _homeItems.postValue(it) }
                }
                is Result.Fail -> {
                    _homeItems.postValue(null)
                }
                is Result.Error -> {
                    _homeItems.postValue(null)
                }
                else -> {
                    _homeItems.postValue(null)
                }
            }
        }
    }

    fun navigateToBuildingDetail(building: Building) {
        _navigateToBuildingDetail.value = building
    }

    fun onBuildingDetailNavigated() {
        _navigateToBuildingDetail.value = null
    }
}