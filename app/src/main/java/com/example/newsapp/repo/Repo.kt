package com.example.newsapp.repo

import com.example.newsapp.network.ApiProvider
import com.example.newsapp.network.response.NewsModel
import retrofit2.Response

class Repo {

    suspend fun getNewsRepo() : Response<NewsModel>{
        return  ApiProvider.apiProvider().getNews()
    }
}