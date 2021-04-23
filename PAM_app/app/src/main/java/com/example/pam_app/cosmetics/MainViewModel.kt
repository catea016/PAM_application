package com.example.pam_app.cosmetics

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    var myResponse: MutableLiveData<Response<Cosmetics>> = MutableLiveData()
    var myCustomItems: MutableLiveData<Response<List<Cosmetics>>> = MutableLiveData()

    fun putItem(cosmetics: Cosmetics) {
        viewModelScope.launch {
            val response = repository.putItem(cosmetics)
            myResponse.value = response
        }
    }

    fun postSmth(cosmetics: Cosmetics) {
        viewModelScope.launch {
            val response = repository.postSmth(cosmetics)
            myResponse.value = response
        }
    }

    fun getBlush() {
        viewModelScope.launch {
            val response = repository.getBlush()
            myCustomItems.value = response
        }
    }

    fun getLipstick() {
        viewModelScope.launch {
            val response = repository.getLipstick()
            myCustomItems.value = response
        }
    }

}