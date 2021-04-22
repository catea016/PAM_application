package com.example.pam_app

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.pam_app.databinding.ActivityCategoryBinding


class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // set the toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        val drawerToggle = ActionBarDrawerToggle(this, binding.drawer, R.string.open, R.string.close)
        binding.drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                binding.drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}


