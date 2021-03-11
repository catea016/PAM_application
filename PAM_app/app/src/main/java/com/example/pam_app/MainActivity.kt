package com.example.pam_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.app.Activity


class MainActivity : AppCompatActivity() {

    lateinit var sendButton: Button
    lateinit var nameEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.editTextTextPersonName)
        sendButton = findViewById(R.id.sendButton)
        sendButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            val name = nameEditText.text.toString()
            intent.putExtra("NAME", name)
            startActivityForResult(intent,1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val secondValue = data!!.getStringExtra("SecondValue")
                val secondValueView: TextView = findViewById(R.id.credentials)
                secondValueView.text = secondValue
            }
        }
    }
}