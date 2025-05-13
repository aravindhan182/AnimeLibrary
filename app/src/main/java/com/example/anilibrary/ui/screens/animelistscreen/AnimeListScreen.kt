package com.example.anilibrary.ui.screens.animelistscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.example.anilibrary.api.anime.Anime
import com.example.anilibrary.navigation.Screen
import com.example.anilibrary.ui.components.ErrorMessageDialog
import com.example.anilibrary.util.isInternetAvailable

@Composable
fun AnimeScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    viewModel: AnimeListViewModel
) {
    val animeList = viewModel.animePagingData.collectAsLazyPagingItems()

    val isRefreshing = animeList.loadState.refresh is LoadState.Loading

    var showNoInternetDialog by remember { mutableStateOf(false) }

    val context = LocalContext.current

    if (showNoInternetDialog) {
        ErrorMessageDialog(
            title = "No Internet Connection",
            message = "Please check your network and try again.",
            onDismiss = {
                showNoInternetDialog = false
                animeList.retry()
            }
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (!isRefreshing) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(count = animeList.itemCount) { index ->
                    val anime = animeList[index]
                    anime?.let {
                        ShowCard(anime = it, onClick = {
                            navController.navigate(Screen.AnimeDetailScreen.createRoute(it.animeId))
                        })
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }

                animeList.apply {
                    when {
                        loadState.refresh is LoadState.Error -> {
                            if (!isInternetAvailable(context)) {
                                showNoInternetDialog = true
                            } else {
                                val e = animeList.loadState.refresh as LoadState.Error
                                item {
                                    ErrorMessageDialog(
                                        title = "Error",
                                        message = "Something went wrong, retry",
                                        onDismiss = {
                                            showNoInternetDialog = false
                                            animeList.retry()
                                        })
                                }
                            }
                        }
                    }
                }
            }
        }
        if (isRefreshing) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}


@Composable
fun ShowCard(anime: Anime, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(model = anime.posterImage.jpg.imageUrl),
                contentDescription = anime.title,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = anime.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "${anime.numberOfEpisodes} Episodes",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )

                Text(
                    text = "⭐ ${anime.rating}",
                    color = Color(0xFFFFA500)
                )
            }
        }
    }
}
