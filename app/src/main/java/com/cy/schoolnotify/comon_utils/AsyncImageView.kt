package com.cy.schoolnotify.comon_utils

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun AsyncImageView(
    data: Any?,
    context: Context,
    contentDescription: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop
) {
//    val imageLoader = LocalContext.current.imageLoader.newBuilder()
//        .logger(DebugLogger())
//        .build()
    val request = ImageRequest.Builder(context)
        .data(data)
        .build()
    AsyncImage(
        model = request,
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier,
    )
}