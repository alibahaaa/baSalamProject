package com.basalam.test.repository

import com.basalam.test.model.Data
import com.basalam.test.network.RetrofitInstance
import retrofit2.Response

class Repository {

    //here we create our repository

    suspend fun getResponse():Response<Data>{
        return RetrofitInstance.api.getResponse()
    }
}