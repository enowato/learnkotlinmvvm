package com.example.eno.cobamvvm.menu.adapter
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.eno.cobamvvm.R
import com.example.eno.cobamvvm.databinding.ItemPlaceBinding
import com.example.eno.cobamvvm.menu.models.responsemodel
import com.example.eno.cobamvvm.menu.viewmodels.Itemplacevm

class ListPlaceAdapter(val context: Context): RecyclerView.Adapter<ListPlaceAdapter.ItemPlaceViewHolder>() {

    private var listPlace: MutableList<responsemodel.Data> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPlaceViewHolder {
        val binding: ItemPlaceBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_place, parent, false)
        return ItemPlaceViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listPlace.size
    }

    override fun onBindViewHolder(holder: ItemPlaceViewHolder, position: Int) {
        holder.bindData(listPlace[holder.adapterPosition])
    }

    fun setData(list: MutableList<responsemodel.Data>){
        this.listPlace = list
    }

    class ItemPlaceViewHolder(private val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(model: responsemodel.Data){
            val viewModel = Itemplacevm(model)
            binding.itemPlace=viewModel
        }
    }
}