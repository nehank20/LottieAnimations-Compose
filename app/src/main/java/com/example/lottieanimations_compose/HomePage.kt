package com.example.lottieanimations_compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomePage(
    onClickedCarSpeeding: () -> Unit,
    onClickedDartGame: () -> Unit,
    onClickedLoaderOne: () -> Unit,
    onClickedLoadingCheck: () -> Unit,
    onClickedPulseLoading: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.padding(bottom = 52.dp),
            text = "Lottie Animations",
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold
        )

        Button(onClick = {
            onClickedCarSpeeding()
        }) {
            Text(text = "Car Speeding", fontSize = 20.sp, fontFamily = FontFamily.Monospace)
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            onClickedDartGame()
        }) {
            Text(text = "Dart Game", fontSize = 20.sp, fontFamily = FontFamily.Monospace)
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            onClickedLoaderOne()
        }) {
            Text(text = "Loader One", fontSize = 20.sp, fontFamily = FontFamily.Monospace)
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            onClickedLoadingCheck()
        }) {
            Text(text = "Loading - Check", fontSize = 20.sp, fontFamily = FontFamily.Monospace)
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            onClickedPulseLoading()
        }) {
            Text(text = "Pulse Loader", fontSize = 20.sp, fontFamily = FontFamily.Monospace)
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}


@Preview
@Composable
fun HomePagePreview() {
    HomePage({}, {}, {}, {}, {})
}

