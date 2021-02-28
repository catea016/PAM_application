package com.example.pam_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class WelcomeActivity : AppCompatActivity() {

    lateinit var main_page_button: Button
    lateinit var login_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        // set date and time
        val textView: TextView = findViewById(R.id.date_time_textView)
        val simpleDateFormat = SimpleDateFormat("MMMM dd, yyyy HH:mm")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        textView.text = currentDateAndTime
        //main page button
        main_page_button = findViewById(R.id.MainPageButton)
        main_page_button.setOnClickListener{
            val intent = Intent(this@WelcomeActivity, CategoryActivity::class.java)
            startActivityForResult(intent,1)
        }
        //login page button
        login_button = findViewById(R.id.loginButton)
        login_button.setOnClickListener{
            val intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
            startActivityForResult(intent,1)
        }
    }
}