package com.basalam.test

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.basalam.test.adapter.MyAdapter
import com.basalam.test.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*
    From ALI BAHAABADI To Mr. NASIRI
    This project developed for Ba Salam.
    In this project I use
    Retrofit,
    RecyclerView,
    Picasso,
    Kotlin Coroutines
    and MVVM
    Im familiar with Hilt and Room but not expert, so i don't use them !
    Also I'm expert in Volley but I found retrofit better , so why Volley ?
     */

    //initialize viewModel
    private lateinit var viewModel: MainViewModel

    //initialize adapter
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set up recyclerview
        setUpRecyclerView()

        //initialize repository
        val repository = Repository()

        //initialize viewModelFactory
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getResponse()
        viewModel.myResponse.observe(this, Observer { response ->

            if (response.isSuccessful) {
                response.body()?.let { myAdapter.setData(it) }
            } else {
                Log.d("ResponseOfPro", response.errorBody().toString());

            }
        })


    }

    private fun setUpRecyclerView() {
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}