package com.justin.taipeizoobrowser.data.source

import com.justin.taipeizoobrowser.data.Result
import com.justin.taipeizoobrowser.data.BuildingsResult

interface DataSource {
    suspend fun getBuildings(): Result<BuildingsResult>
}