package com.example.accountmanager.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.accountmanager.databinding.DetailItemLayoutBinding
import com.example.accountmanager.room.Transaction

class DetailRecyclerAdapter(context: Context?) : RecyclerView.Adapter<DetailRecyclerAdapter.TransactionViewHolder>() {

    private val transactions = mutableListOf<Transaction>()

    class TransactionViewHolder(private val binding: DetailItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(transaction: Transaction) {
            binding.particular.text = transaction.particular
            binding.amount.text = transaction.amount.toString()
            binding.date.text = transaction.date.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = DetailItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(transactions[position])
    }

    override fun getItemCount() = transactions.size

    fun setTransactions(transactions: List<Transaction>) {
        this.transactions.clear()
        this.transactions.addAll(transactions)
        notifyDataSetChanged()
    }
}

