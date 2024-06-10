package com.example.accountmanager.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.accountmanager.adapter.NotificationAdapter
import com.example.accountmanager.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerNotification.adapter= NotificationAdapter(this)
        binding.recyclerNotification.layoutManager = LinearLayoutManager(this)

    }
}