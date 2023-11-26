package com.example.kmasplash.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kmasplash.R

@Composable
fun CoilImage(
    url: String,
    modifier: Modifier = Modifier,
    placeHolder: Painter? = null,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
) {
    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(500)
            .build(),
        placeholder = placeHolder,
        contentDescription = contentDescription ?: "a server image without content description",
        contentScale = contentScale,
        error = painterResource(R.drawable.ic_launcher_background)
    )
}
