package com.example.newsapp.network

import com.example.newsapp.network.response.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiServices {
//    https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=01778b2b55e24d25a5594eab37dd0885

    @Headers("User-Agent: Mozilla/5.0")
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String = "us",
        @Query("category") category: String ="business",
        @Query("apiKey") apiKey: String = "01778b2b55e24d25a5594eab37dd0885"
    ) : Response<NewsModel>



}