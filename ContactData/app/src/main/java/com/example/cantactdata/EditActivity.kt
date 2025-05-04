package com.example.contactdata

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class EditActivity : AppCompatActivity() {
    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        viewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        val etName = findViewById<EditText>(R.id.etName)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val btnSave = findViewById<Button>(R.id.btnSave)

        val mode = intent.getStringExtra("mode")

        if (mode == "edit") {
            val contact = viewModel.getCurrentContact()
            etName.setText(contact.name)
            etPhone.setText(contact.phone)
            etEmail.setText(contact.email)
            etAddress.setText(contact.address)
        }

        btnSave.setOnClickListener {
            val contact = ContactViewModel.Contact(
                etName.text.toString(),
                etPhone.text.toString(),
                etEmail.text.toString(),
                etAddress.text.toString()
            )

            if (mode == "add") {
                viewModel.addContact(contact)
            } else {
                viewModel.updateContact(contact)
            }

            finish()
        }
    }
}