package com.example.accountmanager.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.deishelon.roundedbottomsheet.RoundedBottomSheetDialog
import com.example.accountmanager.adapter.DetailRecyclerAdapter
import com.example.accountmanager.databinding.ActivityDetailBinding
import com.example.accountmanager.databinding.AddottomsheettemBinding
import com.example.accountmanager.databinding.SearchitemlayoutBinding
import com.example.accountmanager.room.AppDatabase
import com.example.accountmanager.room.Transaction
import com.example.accountmanager.utill.DatabaseProvider
import kotlinx.coroutines.launch
import java.util.Date

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var db: AppDatabase
    private lateinit var adapter: DetailRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = DatabaseProvider.getDatabase(applicationContext)
        adapter = DetailRecyclerAdapter(this)

        binding.recyclerDetail.layoutManager = LinearLayoutManager(this)
        binding.recyclerDetail.adapter = adapter

        binding.icAdd.setOnClickListener {
            showAddTransactionDialog()
        }

        binding.imgFind.setOnClickListener {
            searchBottomsheet()
        }
        binding.imgBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        loadTransactions()
    }

    private fun searchBottomsheet() {
        val mBottomSheetDialog = RoundedBottomSheetDialog(this)
        val bottomBinding: SearchitemlayoutBinding = SearchitemlayoutBinding.inflate(LayoutInflater.from(this))
        mBottomSheetDialog.setContentView(bottomBinding.root)
        mBottomSheetDialog.show()
    }
    private fun showAddTransactionDialog() {
        val dialogBinding = AddottomsheettemBinding.inflate(layoutInflater)
        val dialog = android.app.AlertDialog.Builder(this)
            .setTitle("Add Transaction")
            .setView(dialogBinding.root)
            .create()

        dialogBinding.cardAdd.setOnClickListener {
            val particular = dialogBinding.particular.text.toString()
            val amount = dialogBinding.edtAmount.text.toString().toDoubleOrNull()

            if (particular.isNotEmpty() && amount != null) {
                val transaction = Transaction(
                    date = Date(),
                    particular = particular,
                    amount = amount
                )

                lifecycleScope.launch {
                    db.transactionDao().insert(transaction)
                    loadTransactions()
                    dialog.dismiss()
                }
            } else {
                // Handle validation error
            }
        }

        dialog.show()
    }

    private fun loadTransactions() {
        lifecycleScope.launch {
            db.transactionDao().getAllTransactions().collect { transactions ->
                adapter.setTransactions(transactions)
            }
        }
    }

}
