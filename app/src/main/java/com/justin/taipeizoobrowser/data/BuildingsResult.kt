package com.justin.taipeizoobrowser.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BuildingsResult(
    val result: TopResult
) : Parcelable