package com.example.accountmanager.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.accountmanager.DetailActivity
import com.example.accountmanager.R
import com.example.accountmanager.adapter.DashboardRecyclerAdapter
import com.example.accountmanager.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerDashboard.adapter = DashboardRecyclerAdapter(this)
        binding.recyclerDashboard.layoutManager = LinearLayoutManager(this)


    }
}