package com.justin.taipeizoobrowser

import android.app.Application
import com.justin.taipeizoobrowser.data.source.Repository
import com.justin.taipeizoobrowser.util.ServiceLocator
import kotlin.properties.Delegates

class TaipeiZooBrowserApplication : Application() {
    val applicationRepository: Repository
        get() = ServiceLocator.provideRepository()

    companion object {
        var instance: TaipeiZooBrowserApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}