package com.example.accountmanager.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.accountmanager.DetailActivity
import com.example.accountmanager.databinding.ItemDashboardLayoutBinding

class DashboardRecyclerAdapter(context: Context?) :
    RecyclerView.Adapter<DashboardRecyclerAdapter.ViewHolder>() {
    private val context: Context?

    init {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDashboardLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.cardDetail.setOnClickListener {
            context?.startActivity(Intent(context, DetailActivity::class.java))
        }
    }

    override fun getItemCount(): Int {
        return 2
    }

    inner class ViewHolder(binding: ItemDashboardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: ItemDashboardLayoutBinding

        init {
            this.binding = binding
        }
    }
}