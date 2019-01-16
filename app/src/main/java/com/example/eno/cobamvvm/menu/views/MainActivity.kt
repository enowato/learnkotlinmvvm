package com.example.eno.cobamvvm.menu.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.eno.cobamvvm.R
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.eno.cobamvvm.databinding.ActivityMainBinding
import com.example.eno.cobamvvm.menu.viewmodels.MainViewModel
import com.example.eno.cobamvvm.menu.adapter.ListPlaceAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ListPlaceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel=ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.main=viewModel
        setupRecyclerView()
        observeLiveData()
        viewModel.getListPlace()
    }
    private fun setupRecyclerView(){
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerViewPlace.layoutManager = layoutManager
        adapter = ListPlaceAdapter(this)
        binding.recyclerViewPlace.adapter = adapter
    }

    private fun observeLiveData(){
        viewModel.listPlace.observe(this, Observer {
            Log.d("debug","data $it")
            adapter.setData(it?.data!!)
            adapter.notifyDataSetChanged()

        })
        viewModel.error.observe(this, Observer {
            //handle error atau tampilkan pesan errror
        })
    }
}
