package com.example.accountmanager.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.accountmanager.R
import com.example.accountmanager.adapter.DashboardRecyclerAdapter
import com.example.accountmanager.databinding.ActivityDashboardBinding
import com.example.accountmanager.databinding.AdddialogitemlayoutBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imgMenu.setOnClickListener {
            binding.drawer.open()
        }

        binding.notification.setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
        }

        binding.imgAddButton.setOnClickListener {
            val dialogBinding: AdddialogitemlayoutBinding =
                AdddialogitemlayoutBinding.inflate(LayoutInflater.from(this))

            val alertDialog: AlertDialog = MaterialAlertDialogBuilder(
                this, R.style.MyRounded_MaterialComponents_MaterialAlertDialog
            ).setView(dialogBinding.root).show()
            dialogBinding.cardCancel.setOnClickListener {
                alertDialog.dismiss()
            }
            dialogBinding.cardSave.setOnClickListener {
                alertDialog.dismiss()
            }
            alertDialog.setCanceledOnTouchOutside(true)
        }

        binding.recyclerDashboard.adapter = DashboardRecyclerAdapter(this)
        binding.recyclerDashboard.layoutManager = LinearLayoutManager(this)

    }
}