package com.example.trpl5bandroidcourse

import retrofit2.Call
import retrofit2.http.GET

interface APIController {
    @GET("8295002a-2116-40e7-aab0-527e0c6f8362")
    fun getLanguages(): Call<ArrayList<ListModal>>
}