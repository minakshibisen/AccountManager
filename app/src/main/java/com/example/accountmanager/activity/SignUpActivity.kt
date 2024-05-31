package com.example.accountmanager.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.accountmanager.R
import com.example.accountmanager.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textSignin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        binding.cardSignup.setOnClickListener {
            startActivity(Intent(this,DashboardActivity::class.java))
        }
    }
}