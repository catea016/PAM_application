package com.example.pam_app.cosmetics

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_app.R

class CosmeticsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MainViewModel
    private val adapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cosmetics)

        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        System.out.println("beggin post request")
        val myPost = Cosmetics(
            "https://cdn.shopify.com/s/files/1/1338/0845/products/brain-freeze_a_800x1200.jpg?v=1502255076",
            "Lipstick", 10.2F
        )
        viewModel.putItem(myPost)
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                println("successful")
                Log.d("Main", response.body().toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.message())
            } else {
                println("unsuccessful - doesn't have the access to the api")
                Toast.makeText(this, response.code().toString(), Toast.LENGTH_SHORT).show()
            }
        })

        val myPost2 = Cosmetics(
            "https://www.purpicks.com/wp-content/uploads/2018/02/Ombre-Amazonie-CC.png",
            "Eyeshadow", 5.2F
        )
        viewModel.postSmth(myPost2)
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                println("successful")
                Log.d("Main", response.body().toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.message())
            } else {
                println("unsuccessful - doesn't have the access to the api")
                Toast.makeText(this, response.code().toString(), Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.getBlush()
        viewModel.myCustomItems.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let { adapter.setData(it) }
            } else {
                Toast.makeText(this, response.code().toString(), Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.getLipstick()
        viewModel.myCustomItems.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let { adapter.setData(it) }
            } else {
                Toast.makeText(this, response.code().toString(), Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setupRecyclerview() {
        recyclerView = findViewById(R.id.recyclerView2)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
