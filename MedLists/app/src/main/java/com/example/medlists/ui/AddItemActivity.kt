package com.example.medlists.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.medlists.databinding.ActivityAddItemBinding

class AddItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val description = binding.etDescription.text.toString()

            if (name.isBlank()) {
                binding.etName.error = "Введите название"
                return@setOnClickListener
            }

            val resultIntent = Intent().apply {
                putExtra("name", name)
                putExtra("description", description)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
