package com.example.newsapp.screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.network.response.NewsModel
import com.example.newsapp.repo.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val repo  = Repo()

    val data = mutableStateOf<NewsModel?>(null)

    init {
        viewModelScope.launch(Dispatchers.IO) {
             getNews()
        }
    }


     suspend fun getNews(){
        data.value = repo.getNewsRepo().body()
    }

//    init {
//        fetchNews() // Fetch news when ViewModel initializes
//    }
//
//    private fun fetchNews() {
//        viewModelScope.launch(Dispatchers.IO) { // Runs in a background thread
//            try {
//                val response = repo.getNewsRepo() // Calling suspend function inside coroutine
//                Log.d("NewsViewModel", "Response Code: ${response.code()}")
//                Log.d("NewsViewModel", "Response Body: ${response.body()}")
//
//                if (response.isSuccessful) {
//                    response.body()?.let { news ->
//                        data.value = news // Update UI state
//                        Log.d("NewsViewModel", "Data Updated: $news")
//                    }
//                } else {
//                    Log.e("NewsViewModel", "Failed to fetch news: ${response.errorBody()?.string()}")
//                }
//            } catch (e: Exception) {
//                Log.e("NewsViewModel", "Error fetching news", e)
//            }
//        }
//    }

}