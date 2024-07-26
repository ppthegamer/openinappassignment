package com.example.mathongoandroiassignmenrt.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Campaign
import androidx.compose.material.icons.outlined.Class
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationModel(val route: String, val title: String, val icon: ImageVector) {
 data object    LinksScreen : BottomNavigationModel("link", "Links", Icons.Default.Link)
    data  object CoursesScreen : BottomNavigationModel("courses", "Courses", Icons.Outlined.Class)
    data  object CampaignsScreen : BottomNavigationModel("campaigns", "Campaigns", Icons.Outlined.Campaign)

    data object ProfileScreen : BottomNavigationModel("profile", "Profile", Icons.Default.Person)
}