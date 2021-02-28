package com.example.pam_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText


class LoginActivity : AppCompatActivity() {

    lateinit var sendButton: Button
    lateinit var nameEditText: EditText
    lateinit var phoneEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        nameEditText = findViewById(R.id.editTextTextPersonName)
        phoneEditText = findViewById(R.id.editTextPhone)
        sendButton = findViewById(R.id.sendButton)
        sendButton.setOnClickListener {
            val intent = Intent(this@LoginActivity, CategoryActivity::class.java)
            val name = nameEditText.text.toString()
            val phone = phoneEditText.text.toString()
            startActivityForResult(intent,1)
        }

    }

}