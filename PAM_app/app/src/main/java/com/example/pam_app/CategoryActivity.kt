package com.example.pam_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pam_app.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backImageView.setOnClickListener {
            val intent = Intent(this@CategoryActivity, WelcomeActivity::class.java)
            startActivity(intent)
        }

        binding.expandAllButton.setOnClickListener {
            val intent1 = Intent(
                this@CategoryActivity,
                com.example.pam_app.foodAndDrinks.RecyclerActivity::class.java
            )
            startActivity(intent1)
        }

        binding.expandAllButton2.setOnClickListener {
            val intent2 = Intent(
                this@CategoryActivity,
                com.example.pam_app.cosmetics.CosmeticsActivity::class.java
            )
            startActivity(intent2)
        }
    }
}


