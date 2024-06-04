package com.example.accountmanager.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.accountmanager.databinding.ItemNotificationLayoutBinding

class NotificationAdapter (context: Context?) : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {
    private val context: Context?
    init {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNotificationLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {}
    override fun getItemCount(): Int {
        return 4
    }

    inner class ViewHolder(binding: ItemNotificationLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: ItemNotificationLayoutBinding

        init {
            this.binding = binding
        }
    }
}
