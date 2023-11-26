package com.example.kmasplash.presentation.navigation

sealed class RouteName(val route : String){
    object  HomeScreen : RouteName("home_screen")
    object SearchScreen : RouteName("search_screen")
    object ProfileScreen : RouteName("profile_screen")

    object CreatePostScreen : RouteName("create_post_screen")

        object NotificationScreen : RouteName("notification_screen")
}
