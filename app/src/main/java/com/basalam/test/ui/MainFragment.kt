package com.basalam.test.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.basalam.test.MainViewModel
import com.basalam.test.MainViewModelFactory
import com.basalam.test.R
import com.basalam.test.adapter.CellClickListener
import com.basalam.test.adapter.MyAdapter
import com.basalam.test.model.Data
import com.basalam.test.repository.Repository
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment(),CellClickListener{

    //initialize viewModel
    private lateinit var viewModel: MainViewModel

    //initialize adapter
    private val myAdapter by lazy { MyAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  =  inflater.inflate(R.layout.fragment_main, container, false)
        //set up recyclerview
        setUpRecyclerView(view)


        //initialize repository
        val repository = Repository()

        //initialize viewModelFactory
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


        viewModel.getResponse()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->

            if (response.isSuccessful) {
                response.body()?.let { myAdapter.setData(it) }
            } else {
                Log.d("ResponseOfPro", response.errorBody().toString());
            }
        })



        return view
    }

    private fun setUpRecyclerView(view:View) {
        view.recyclerView.adapter = myAdapter
        view.recyclerView.layoutManager = LinearLayoutManager(activity)
    }

    override fun onCellClickListener(data: Data, pos: Int,view:View) {

        val action = MainFragmentDirections.actionMainFragmentToSecondFragment(data[pos])
        findNavController().navigate(action)

//        Toast.makeText(activity,data[pos].title + "",Toast.LENGTH_SHORT).show()

    }

}