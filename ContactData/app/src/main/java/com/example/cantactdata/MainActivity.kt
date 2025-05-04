package com.example.contactdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        val tvContactInfo = findViewById<TextView>(R.id.tvContactInfo)
        val btnEdit = findViewById<Button>(R.id.btnEdit)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnPrevious = findViewById<ImageButton>(R.id.btnPrevious)
        val btnNext = findViewById<ImageButton>(R.id.btnNext)

        updateContactInfo(tvContactInfo)

        btnEdit.setOnClickListener {
            if (viewModel.hasContacts()) {
                val intent = Intent(this, EditActivity::class.java)
                intent.putExtra("mode", "edit")
                startActivity(intent)
            }
        }

        btnAdd.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("mode", "add")
            startActivity(intent)
        }

        btnPrevious.setOnClickListener {
            if (viewModel.moveToPrevious()) {
                updateContactInfo(tvContactInfo)
            }
        }

        btnNext.setOnClickListener {
            if (viewModel.moveToNext()) {
                updateContactInfo(tvContactInfo)
            }
        }
    }

    private fun updateContactInfo(textView: TextView) {
        val contact = viewModel.getCurrentContact()
        textView.text = if (viewModel.hasContacts()) {
            "Имя: ${contact.name}\nТелефон: ${contact.phone}\nEmail: ${contact.email}\nАдрес: ${contact.address}"
        } else {
            "Нет контактов"
        }
    }

    override fun onResume() {
        super.onResume()
        updateContactInfo(findViewById(R.id.tvContactInfo))
    }
}