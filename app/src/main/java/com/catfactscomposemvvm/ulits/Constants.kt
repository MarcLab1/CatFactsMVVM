package com.catfactscomposemvvm.ulits

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.catfactscomposemvvm.ui.presentation.BottomNavItem

object Constants {
    const val BASE_URL = "https://catfact.ninja"

    val BottomNavItems = listOf(
        BottomNavItem(
            label = "catfact",
            icon = Icons.Filled.Home,
            route = "catfact"
        ),
        BottomNavItem(
            label = "catfacts",
            icon = Icons.Filled.Face,
            route = "catfacts"
        ),
        BottomNavItem(
            label = "hilttest",
            icon = Icons.Filled.Star,
            route = "hilttest"
        )
    )
}