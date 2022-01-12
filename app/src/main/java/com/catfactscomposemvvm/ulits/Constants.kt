package com.catfactscomposemvvm.ulits

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.catfactscomposemvvm.ui.presentation.BottomNavItem

object Constants {
    const val BASE_URL = "https://catfact.ninja"

    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Cat Fact",
            icon = Icons.Filled.Home,
            route = "catfact"
        ),
        BottomNavItem(
            label = "Cat Facts",
            icon = Icons.Filled.Face,
            route = "catfacts"
        ),
        BottomNavItem(
            label = "Breeds",
            icon = Icons.Filled.ThumbUp,
            route = "breeds"
        ),
        BottomNavItem(
            label = "Hilt Test1",
            icon = Icons.Filled.Star,
            route = "hilttest"
        ),
        BottomNavItem(
            label = "Hilt Test2",
            icon = Icons.Filled.Info,
            route = "injectiontest"
        )
    )
}