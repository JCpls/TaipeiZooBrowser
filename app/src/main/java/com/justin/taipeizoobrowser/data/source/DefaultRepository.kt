package com.justin.taipeizoobrowser.data.source

import com.justin.taipeizoobrowser.data.BuildingsResult
import com.justin.taipeizoobrowser.data.HomeItem
import com.justin.taipeizoobrowser.data.Result


class DefaultRepository(private val apiDataSource: DataSource): Repository {
    override suspend fun getBuildings(): Result<List<HomeItem>> {
        return apiDataSource.getBuildings()
    }
}