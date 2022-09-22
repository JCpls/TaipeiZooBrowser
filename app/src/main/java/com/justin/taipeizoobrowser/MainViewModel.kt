package com.justin.taipeizoobrowser

import androidx.lifecycle.ViewModel
import com.justin.taipeizoobrowser.data.BuildingsResult
import com.justin.taipeizoobrowser.data.source.Repository
import com.justin.taipeizoobrowser.data.Result
import kotlinx.coroutines.*

class MainViewModel(private val repository: Repository): ViewModel() {

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        getData()
    }

    private fun getData() {
        coroutineScope.launch {
            getBuildings()
        }
    }

    private suspend fun getBuildings(): BuildingsResult? {
        return withContext(Dispatchers.IO) {
            when (val result = repository.getBuildings()) {
                is Result.Success -> {
                    result.data
                }
                else -> {
                    null
                }
            }
        }
    }
}