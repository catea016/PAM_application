package com.example.pam_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pam_app.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.sendButton.setOnClickListener {
            val intent = Intent(this@LoginActivity, CategoryActivity::class.java)
            val name = binding.editTextTextPersonName.text
            val phone = binding.editTextPhone.text
            startActivityForResult(intent,1)
        }
    }

}