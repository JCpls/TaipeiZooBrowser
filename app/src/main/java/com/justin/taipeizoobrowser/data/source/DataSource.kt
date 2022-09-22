package com.justin.taipeizoobrowser.data.source

import com.justin.taipeizoobrowser.data.Result
import com.justin.taipeizoobrowser.data.BuildingsResult
import com.justin.taipeizoobrowser.data.HomeItem

interface DataSource {
    suspend fun getBuildings(): Result<List<HomeItem>>
}