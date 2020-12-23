package com.basalam.test.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class Data : ArrayList<Data.DataItem>(){
    @Parcelize
    data class DataItem(
        val albumId: Int,
        val id: Int,
        val thumbnailUrl: String,
        val title: String,
        val url: String
    ) :Parcelable
}