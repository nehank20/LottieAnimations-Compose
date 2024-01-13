package com.example.lottieanimations_compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lottieanimations_compose.animation_files.CarSpeeding
import com.example.lottieanimations_compose.animation_files.DartGame
import com.example.lottieanimations_compose.animation_files.LoaderCheck
import com.example.lottieanimations_compose.animation_files.LoaderOne
import com.example.lottieanimations_compose.animation_files.PulseLoading

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_page") {

        composable("home_page") {
            HomePage(
                onClickedCarSpeeding = {
                    navController.navigate("car_speeding")
                },
                onClickedDartGame = {
                    navController.navigate("dart_game")
                },
                onClickedLoaderOne = {
                    navController.navigate("loader_one")
                },
                onClickedLoadingCheck = {
                    navController.navigate("loader_check")
                },
                onClickedPulseLoading = {
                    navController.navigate("pulse_loading")
                }
            )
        }

        composable("car_speeding") {
            CarSpeeding()
        }

        composable("dart_game") {
            DartGame()
        }

        composable("loader_one") {
            LoaderOne(){
                navController.navigate("detail_screen")
            }
        }

        composable("loader_check") {
            LoaderCheck(){
                navController.navigate("detail_screen")
            }
        }

        composable("pulse_loading") {
            PulseLoading()
        }

        composable("detail_screen") {
            DetailPageScreen()
        }
    }

}