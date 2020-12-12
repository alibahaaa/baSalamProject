package com.basalam.test.network


import com.basalam.test.model.Data
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    //here we send a GET req. we can add query for 'albumId' but bcz it's for test i don't use it.
    @GET("photos?albumId=1")
    suspend fun getResponse(): Response<Data>

}