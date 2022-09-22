package com.justin.taipeizoobrowser.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImportDate(
    val date: String,
    val timezone_type: Int,
    val timezone: String
): Parcelable


