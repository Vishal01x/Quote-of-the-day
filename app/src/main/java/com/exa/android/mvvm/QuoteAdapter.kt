package com.exa.android.mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.exa.android.mvvm.databinding.QuoteItemBinding


class QuoteAdapter : ListAdapter<Quote, QuoteAdapter.ViewHolder>(DiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = QuoteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
          val quote = getItem(position)
          holder.bind(quote)
    }

    class ViewHolder(val binding : QuoteItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(quote : Quote){
            binding.quote = quote
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<Quote>() {
        override fun areItemsTheSame(oldItem: Quote, newItem: Quote): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Quote, newItem: Quote): Boolean {
            return  oldItem == newItem
        }
    }

}