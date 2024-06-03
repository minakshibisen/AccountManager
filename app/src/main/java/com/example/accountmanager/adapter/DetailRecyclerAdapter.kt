package com.example.accountmanager.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.accountmanager.databinding.DetailItemLayoutBinding

class DetailRecyclerAdapter(context: Context?) : RecyclerView.Adapter<DetailRecyclerAdapter.ViewHolder>() {
    private val context: Context?
    init {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DetailItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {}
    override fun getItemCount(): Int {
        return 4
    }

    inner class ViewHolder(binding: DetailItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: DetailItemLayoutBinding

        init {
            this.binding = binding
        }
    }
}

