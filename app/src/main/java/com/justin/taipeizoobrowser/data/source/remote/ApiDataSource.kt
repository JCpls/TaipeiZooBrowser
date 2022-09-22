package com.justin.taipeizoobrowser.data.source.remote

import android.util.Log
import com.justin.taipeizoobrowser.data.BuildingsResult
import com.justin.taipeizoobrowser.data.Result
import com.justin.taipeizoobrowser.data.source.DataSource
import com.justin.taipeizoobrowser.network.WebApi

object ApiDataSource : DataSource {
    override suspend fun getBuildings(): Result<BuildingsResult> {
        return try {
            val buildingsResult = WebApi.retrofitService.getBuildings()
            Result.Success(buildingsResult)
        } catch (e: Exception) {
            Log.w("Jim", "[${this::class.simpleName}] exception=${e.message}")
            Result.Error(e)
        }
    }
}