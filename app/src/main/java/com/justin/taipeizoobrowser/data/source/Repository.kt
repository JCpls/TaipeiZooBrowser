package com.justin.taipeizoobrowser.data.source

import com.justin.taipeizoobrowser.data.BuildingsResult
import com.justin.taipeizoobrowser.data.Result

interface Repository {
    suspend fun getBuildings(): Result<BuildingsResult>
}