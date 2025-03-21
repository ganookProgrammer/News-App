package com.example.newsapp.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.newsapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeUi(viewModel: NewsViewModel,paddingValues: PaddingValues) {


    val data = viewModel.data.value?.articles?.filter { article ->
        val title = article.title?.trim()
        val description = article.description?.trim()
        val imageUrl = article.urlToImage?.trim()
        val author = article.author?.trim()

        // Remove any article where ANY field is empty or null
        !title.isNullOrEmpty() && !description.isNullOrEmpty()
                && !imageUrl.isNullOrEmpty() && !author.isNullOrEmpty()
    } ?: emptyList()

    Log.d("data", data.toString())

    Scaffold(topBar = {
        CenterAlignedTopAppBar({
            Text("Latest News")
        },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorResource(R.color.custom_blue),
                titleContentColor = Color.White
            ))
    }) { innerPadding->


    LazyColumn(Modifier.padding(innerPadding)
        .padding(top = 10.dp)) {
        items(data) {data ->

                    CardItems(
                        title = data.title,
                        description = data.description,
                        urlToImage = data.urlToImage,
                        author = data.author
                    )
                }

        }
    }
}



@Composable
fun CardItems(title: String, description: String
              , urlToImage: String,author : String) {




    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 20.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .height(100.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            SubcomposeAsyncImage(
                model = "$urlToImage",
                loading = {
                    CircularProgressIndicator()
                },
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(shape = RoundedCornerShape(2.dp))
                    .width(150.dp)
            )
            Column(Modifier.padding(8.dp)
                .fillMaxSize()) {
                Text(
                    text = title, fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    maxLines = 2,
                    lineHeight = 1.2.em,
                )

                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = description,
                    fontSize = 12.sp,
                    maxLines = 2,
                    lineHeight = 1.2.em

                )
                Text(
                    text = "author: $author",
                    fontSize = 12.sp,


                )
            }
        }

    }
    Spacer(Modifier.height(15.dp))

}