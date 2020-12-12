package com.basalam.test.model

class Data : ArrayList<Data.DataItem>(){
    data class DataItem(
        val albumId: Int,
        val id: Int,
        val thumbnailUrl: String,
        val title: String,
        val url: String
    )
}