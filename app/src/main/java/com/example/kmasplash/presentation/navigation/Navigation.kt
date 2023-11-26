package com.example.kmasplash.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kmasplash.presentation.screens.home.*
import com.example.kmasplash.presentation.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination =  RouteName.HomeScreen.route) {
        composable(RouteName.HomeScreen.route) {
            val postViewModel = hiltViewModel<HomeViewModel>()
            val homeState by postViewModel.postState.collectAsState()
            HomeScreen(modifier = Modifier, postsListState = homeState)
        }
        composable(RouteName.SearchScreen.route,
            ) {
            SearchScreen(modifier = Modifier)
        }
        composable(RouteName.CreatePostScreen.route) {
            val postViewModel = hiltViewModel<HomeViewModel>()
            val homeState by postViewModel.postState.collectAsState()
            CreatePostScreen(modifier = Modifier, postsListState = homeState)
        }
        composable(RouteName.ProfileScreen.route) {
            val postViewModel = hiltViewModel<HomeViewModel>()
            val homeState by postViewModel.postState.collectAsState()
            ProfileScreen(modifier = Modifier, postsListState = homeState)
        }
        composable(RouteName.NotificationScreen.route) {
            val postViewModel = hiltViewModel<HomeViewModel>()
            val homeState by postViewModel.postState.collectAsState()
            NotificationScreen(modifier = Modifier, postsListState = homeState)
        }

    }
}
