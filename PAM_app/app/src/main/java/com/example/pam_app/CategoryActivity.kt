package com.example.pam_app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.ImageView

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val back_button = findViewById(R.id.backImageView) as ImageView
        back_button.setOnClickListener{
            val intent = Intent(this@CategoryActivity, WelcomeActivity::class.java)
            startActivity(intent)
        }

        val expand_all_1_button = findViewById(R.id.expandAllButton) as Button
        expand_all_1_button.setOnClickListener {
            val intent1 = Intent(this@CategoryActivity, com.example.pam_app.foodAndDrinks.RecyclerActivity::class.java)
            startActivity(intent1)
        }


    }
}


