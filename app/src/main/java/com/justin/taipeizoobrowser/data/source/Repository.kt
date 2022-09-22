package com.justin.taipeizoobrowser.data.source

import com.justin.taipeizoobrowser.data.BuildingsResult
import com.justin.taipeizoobrowser.data.HomeItem
import com.justin.taipeizoobrowser.data.Result

interface Repository {
    suspend fun getBuildings(): Result<List<HomeItem>>
}