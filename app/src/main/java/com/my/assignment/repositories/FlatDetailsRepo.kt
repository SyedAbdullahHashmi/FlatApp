package com.my.assignment.repositories

import com.my.assignment.networkservices.ApiService
import com.my.assignment.networkservices.RetrofitService

class FlatDetailsRepo {


    private val apiService: ApiService by lazy {
        RetrofitService.getRetrofitClient()
    }

    suspend fun getFlatDetails() = apiService.getFlatDetails()


}