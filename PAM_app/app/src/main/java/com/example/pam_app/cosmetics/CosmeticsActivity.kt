package com.example.pam_app.cosmetics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_app.R
import com.example.pam_app.cosmetics.api.Cosmetics
import com.example.pam_app.cosmetics.api.MainAdapter
import com.example.pam_app.cosmetics.api.Repository
import com.example.pam_app.cosmetics.model.Model
import com.example.pam_app.cosmetics.presenter.Presenter
import com.example.pam_app.cosmetics.view.View
import com.example.pam_app.databinding.ActivityCosmeticsBinding

class CosmeticsActivity : AppCompatActivity(), View {

    private lateinit var binding: ActivityCosmeticsBinding
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCosmeticsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter = Presenter(this, Model(Repository()), this, adapter)
        setupRecyclerview()
        //presenter.initView()
        init()
    }

    override fun init() {
        System.out.println("beggin post request")
        presenter.getBlush()
        presenter.getLipstick()
        val myPost = Cosmetics(
            "https://cdn.shopify.com/s/files/1/1338/0845/products/brain-freeze_a_800x1200.jpg?v=1502255076",
            "Lipstick", 10.2F
        )
        presenter.putItem(myPost)

        val myPost2 = Cosmetics(
            "https://www.purpicks.com/wp-content/uploads/2018/02/Ombre-Amazonie-CC.png",
            "Eyeshadow", 5.2F
        )
        presenter.postSmth(myPost2)
    }

    private fun setupRecyclerview() {
        recyclerView = findViewById(R.id.recyclerView2)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}

