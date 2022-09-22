package com.justin.taipeizoobrowser.data

sealed class HomeItem {
    abstract val id: Int

    data class BuildingItem(val building: Building) : HomeItem() {
        override val id: Int
            get() = building._id
    }
}
