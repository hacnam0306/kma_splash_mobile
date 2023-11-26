package com.example.kmasplash.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigation (
     val route : String,
     val title : String,
     val icon : ImageVector
 ){
    object  HomeScreen : BottomNavigation(RouteName.HomeScreen.route,"Home", Icons.Outlined.Home)
    object SearchScreen : BottomNavigation(RouteName.SearchScreen.route,"Search", Icons.Outlined.Search)
    object  CreatePostScreen : BottomNavigation(RouteName.CreatePostScreen.route,"", Icons.Outlined.Add)


    object NotificationScreen : BottomNavigation(RouteName.NotificationScreen.route,"Notification", Icons.Outlined.Notifications)

    object ProfileScreen : BottomNavigation(RouteName.ProfileScreen.route,"Profile", Icons.Outlined.Person)


}
