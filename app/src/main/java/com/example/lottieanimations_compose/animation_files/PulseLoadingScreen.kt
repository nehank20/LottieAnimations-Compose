package com.example.lottieanimations_compose.animation_files

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.lottieanimations_compose.R


@Composable
fun PulseLoading() {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        PulseAnimation()
        Image(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .border(width = 2.dp, color = Color.LightGray, shape = CircleShape),
            painter = painterResource(id = R.drawable.random_user),
            contentDescription = "user_image",
            contentScale = ContentScale.Crop
        )

    }

}

@Composable
fun PulseAnimation() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.pulse_loading))

    LottieAnimation(
        modifier = Modifier.size(300.dp),
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
}

@Preview
@Composable
fun PulseLoadingPreview() {
    PulseLoading()
}