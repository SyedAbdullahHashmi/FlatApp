package com.my.assignment.networkservices

import com.my.assignment.models.FlatDetailsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    /**
     * This Api fetching product list from server
     */
    @GET(ApiEndPoints.FLAT_LIST)
    suspend fun getFlatDetails(): Response<FlatDetailsModel?>?
}