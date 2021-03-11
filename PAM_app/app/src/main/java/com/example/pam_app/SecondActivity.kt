package com.example.pam_app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button


class SecondActivity : AppCompatActivity() {

    lateinit var sendBackButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val nameValue = intent.getStringExtra("NAME")
        val messageTextView: TextView = findViewById(R.id.name)
        messageTextView.text = nameValue


        sendBackButton = findViewById(R.id.sendBackButton)
        sendBackButton.setOnClickListener {

            val message = "Your name is $nameValue"
            val resultIntent = Intent()
            resultIntent.putExtra("SecondValue", message)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}


