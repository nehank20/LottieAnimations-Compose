package com.example.lottieanimations_compose.animation_files

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.lottieanimations_compose.R

@Composable
fun LoaderCheck(onAnimationComplete : () -> Unit) {

    var showAnimation by remember {
        mutableStateOf(false)
    }

    Column(Modifier.fillMaxSize()) {

        UserForm {
            showAnimation = true
        }
        CheckAnimation(
            showAnimation,
            modifier = Modifier
                .size(100.dp)
        ){
            onAnimationComplete()
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserForm(onSubmitButtonClicked: () -> Unit) {
    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = username,
            onValueChange = {
                username = it
            },
            label = {
                Text(text = "Please enter password")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(text = "Please enter password")
            }
        )

        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = {
            onSubmitButtonClicked()
        }) {
            Text(text = "Submit", fontSize = 16.sp, fontFamily = FontFamily.Monospace)
        }

    }
}

@Composable
fun CheckAnimation(isPlaying: Boolean, modifier: Modifier, onAnimationComplete: () -> Unit) {

    var showCompleteText by remember {
        mutableStateOf(false)
    }

    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.loading_check)
    )

    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {


        LaunchedEffect(key1 = progress) {
            if (progress == 1F) {
                showCompleteText = true
                onAnimationComplete()
            }
        }

        LottieAnimation(
            composition = composition,
            modifier = modifier,
            progress = {
                progress
            })

        if (showCompleteText) {
            ShowCompleteText()
        }


    }


}

@Composable
fun ShowCompleteText() {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text(text = "Check completed")
    }
}

@Preview
@Composable
fun PreviewScreens() {
    UserForm({})
}
