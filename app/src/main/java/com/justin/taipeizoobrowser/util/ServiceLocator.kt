package com.justin.taipeizoobrowser.util

import androidx.annotation.VisibleForTesting
import com.justin.taipeizoobrowser.data.source.DefaultRepository
import com.justin.taipeizoobrowser.data.source.Repository
import com.justin.taipeizoobrowser.data.source.remote.ApiDataSource

object ServiceLocator {

    @Volatile
    var repository: Repository? = null
        @VisibleForTesting set

    fun provideRepository(): Repository {
        synchronized(this) {
            return repository
                ?: createApplicationRepository()
        }
    }

    private fun createApplicationRepository(): Repository {
        return DefaultRepository(
            ApiDataSource
        )
    }
}