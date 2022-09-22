package com.justin.taipeizoobrowser.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Building(
    val _id: Int,
    val _importdate: ImportDate,
    val e_no: String,
    val e_category: String,
    val e_name: String,
    val e_pic_url: String,
    val e_info: String,
    val e_memo: String,
    val e_geo: String,
    val e_url: String
): Parcelable

