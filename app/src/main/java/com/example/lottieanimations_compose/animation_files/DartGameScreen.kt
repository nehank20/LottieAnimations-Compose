package com.example.lottieanimations_compose.animation_files

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.lottieanimations_compose.R

@Composable
fun DartGame() {

    Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.padding(16.dp)) {
        Text(text = "Click on animation to restart")
    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        val composition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(R.raw.dart_game)
        )
        var isPlaying by remember {
            mutableStateOf(true)
        }

        val progress by animateLottieCompositionAsState(
            composition = composition,
            isPlaying = isPlaying
        )

        LaunchedEffect(key1 = progress) {
            if (progress == 0F) {
                isPlaying = true
            }

            if (progress == 1F) {
                isPlaying = false
            }
        }


        LottieAnimation(
            modifier = Modifier
                .size(300.dp)
                .clickable {
                    isPlaying = true
                },
            progress = {
                progress

            },
            composition = composition,

            )
    }

}