package com.example.newsapp.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage


@Composable
fun HomeUi(viewModel: NewsViewModel) {


    val data = viewModel.data.value

    val showData = data?.articles ?: emptyList()

    Log.d("data", data.toString())

//    LazyColumn {
//        items(showData) {
//            CardItems(
//                it.title
//                , it.description
//                , it.urlToImage
//            )
//        }
//    }



}

@Composable
fun CardItems(title : String , description : String,image : String) {


Card(modifier = Modifier.fillMaxWidth(0.9f)) {

    Row(modifier = Modifier.fillMaxSize()
        .padding(100.dp)) {
        SubcomposeAsyncImage(
            model = image,
            loading = {
                CircularProgressIndicator()
            },
            contentDescription = null,
        )

        Column {
            Text(text = title, fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold)

            Text(text = description,
                fontSize = 16.sp)
        }
    }


}}