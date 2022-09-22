package com.justin.taipeizoobrowser.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BuildingsResult(
    val result: Buildings
) : Parcelable {

    //in order to get the data in depth layer
    fun toHomeItem() : List<HomeItem> {
        val items = mutableListOf<HomeItem>()
        result.let { buildings ->
            buildings.results.forEach { building ->
                items.add(HomeItem.BuildingItem(building))
            }
        }
        return items
    }
}