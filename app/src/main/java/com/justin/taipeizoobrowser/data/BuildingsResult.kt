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

                //in order to load the picture from API Taipei Zoo
                if (!building.e_pic_url.isNullOrEmpty()) {
                    val urlBegin = building.e_pic_url.substring(0, 4)
                    val urlEnd = building.e_pic_url.substring(4, building.e_pic_url.length)
                    building.e_pic_url = urlBegin + "s" + urlEnd
                }

                items.add(HomeItem.BuildingItem(building))
            }
        }
        return items
    }
}