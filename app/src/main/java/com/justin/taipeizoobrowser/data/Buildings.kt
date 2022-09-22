package com.justin.taipeizoobrowser.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Buildings(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val sort: String,
    val results: List<Building>
): Parcelable

