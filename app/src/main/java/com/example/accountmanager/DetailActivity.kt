package com.example.accountmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.deishelon.roundedbottomsheet.RoundedBottomSheetDialog
import com.example.accountmanager.databinding.ActivityDetailBinding
import com.example.accountmanager.databinding.AddottomsheettemBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icAdd.setOnClickListener {
            addBottomsheet()
        }
    }
    private fun addBottomsheet() {
        val mBottomSheetDialog = this?.let { RoundedBottomSheetDialog(it) }
        val bottomBinding: AddottomsheettemBinding =
            AddottomsheettemBinding.inflate(LayoutInflater.from(this))
        mBottomSheetDialog?.setContentView(bottomBinding.root)
        mBottomSheetDialog?.show()
        bottomBinding.icClose.setOnClickListener {
            mBottomSheetDialog?.dismiss()
        }
        bottomBinding.cardAdd.setOnClickListener {
            mBottomSheetDialog?.dismiss()
        }
    }
}