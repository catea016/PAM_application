package com.example.pam_app

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pam_app.databinding.ActivityWelcomeBinding
import java.text.SimpleDateFormat
import java.util.*

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

/*    lateinit var main_page_button: Button
    lateinit var login_button: Button*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // set date and time
        val textView: TextView = binding.dateTimeTextView
        val simpleDateFormat = SimpleDateFormat("MMMM dd, yyyy HH:mm")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        textView.text = currentDateAndTime
        //main page button
       // main_page_button = findViewById(R.id.MainPageButton)
        binding.MainPageButton.setOnClickListener{
            val intent = Intent(this@WelcomeActivity, CategoryActivity::class.java)
            startActivityForResult(intent,1)
        }
        //login page button
       // login_button = findViewById(R.id.loginButton)
        binding.loginButton.setOnClickListener{
            val intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
            startActivityForResult(intent,1)
        }
    }
}