package com.example.kmasplash.presentation.screens.home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import com.example.kmasplash.presentation.components.AppHeader
import com.example.kmasplash.presentation.components.BackgroundableScaffold
import com.example.kmasplash.presentation.components.CoilImage
import com.example.kmasplash.presentation.state.PostListState
import com.example.kmasplash.presentation.ui.theme.Dimens


@ExperimentalMaterial3Api
@Composable
fun HomeScreen(modifier: Modifier , postsListState:PostListState) {
BackgroundableScaffold (
    topBar = { AppHeader(onBackClick = {  }, modifier = modifier) },
    modifier = Modifier.padding( Dimens.PaddingSmall)
) {
    Box(
        modifier
    ){
        if(postsListState.isLoading){
            Box(modifier = modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
            }
        }else if (!postsListState.error.isNullOrEmpty()) {
            Box(modifier = modifier.fillMaxSize()) {
                Text(text = postsListState.error.toString(), modifier = modifier.align(Alignment.Center))
            }
        }
        if(postsListState.posts?.isNotEmpty()!!){
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(3),
                verticalItemSpacing = 4.dp,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                content = {
                    items(postsListState.posts) { photo ->
                        CoilImage(
                            url = photo.fileName ?: photo.URL,
                            contentDescription = photo.description,
                            modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(Dimens.XS)).wrapContentHeight()
                        )
                    }
                },
                modifier = Modifier.fillMaxSize()
            )
            }
 }
    }
}




