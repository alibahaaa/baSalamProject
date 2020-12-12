package com.basalam.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basalam.test.model.Data
import com.basalam.test.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {

    //here we create MainViewModel class


    val myResponse : MutableLiveData<Response<Data>> = MutableLiveData()

    fun getResponse(){
        viewModelScope.launch {
            val response = repository.getResponse()
            myResponse.value = response
        }
    }

}