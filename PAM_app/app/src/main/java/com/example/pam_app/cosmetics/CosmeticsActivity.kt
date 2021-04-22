package com.example.pam_app.cosmetics

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_app.R
import com.example.pam_app.cosmetics.view.View
import com.example.pam_app.cosmetics.api.Cosmetics
import com.example.pam_app.cosmetics.api.MainAdapter
import com.example.pam_app.cosmetics.api.Repository
import com.example.pam_app.cosmetics.model.Model
import com.example.pam_app.cosmetics.presenter.Presenter
import com.example.pam_app.databinding.ActivityCosmeticsBinding
import retrofit2.Response


class CosmeticsActivity : AppCompatActivity() {

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

            presenter = Presenter(this, Model(Repository()))
            setupRecyclerview()
            presenter.initView()
        }

        override fun init() {
            System.out.println("beggin post request")
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
            presenter.getBlush()
            presenter.getLipstick()
        }

        override fun showGetResponse(response: Response<List<Cosmetics>>) {
            if (response.isSuccessful) {
                response.body()?.let { adapter.setData(it) }
            } else {
                Toast.makeText(this, response.code().toString(), Toast.LENGTH_SHORT).show()
            }
        }

        override fun showPostResponse(response: Response<Cosmetics>) {
            if (response.isSuccessful) {
                println("successful")
                Log.d("Main", response.body().toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.message())
            } else {
                println("unsuccessful POST request - doesn't have the access to the api")
                Toast.makeText(this, response.code().toString(), Toast.LENGTH_SHORT).show()
            }
        }

        private fun setupRecyclerview() {
            recyclerView = findViewById(R.id.recyclerView2)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }
}
