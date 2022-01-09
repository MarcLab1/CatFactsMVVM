package com.catfactscomposemvvm.ui.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.catfactscomposemvvm.ui.presentation.catfact.Catfact
import com.catfactscomposemvvm.ui.presentation.catfacts.Catfacts
import com.catfactscomposemvvm.ui.presentation.hilty.Hilty
import com.catfactscomposemvvm.ulits.Constants
import dagger.hilt.android.AndroidEntryPoint


@Composable
fun MyBottomNavigation() {
    val navController = rememberNavController()

    Surface() {
        Scaffold(
            bottomBar = {
                BottomNavigationBar(navController = navController)
            }, content = {
                NavHostStart(navController = navController)
            }
        )
    }
}


@Composable
fun BottomNavigationBar(navController: NavController) {

    BottomNavigation() {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        Constants.BottomNavItems.forEach { item ->

            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {

                    navController.navigate(item.route) {
                        popUpTo(Constants.BottomNavItems.get(0).route) //so the back button takes us back to first, then back to the upper navigaiton (with buttons)
                        launchSingleTop = true  //no duplocates on the back stack
                    }
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.label)
                },
                label = {
                    Text(text = item.label)
                },
                alwaysShowLabel = true
            )
        }
    }
}

@Composable
fun NavHostStart(
    navController: NavHostController
) {
    NavHost(navController, startDestination = Constants.BottomNavItems.get(0).route,
        modifier = Modifier.padding(10.dp)) {
        composable(route = Constants.BottomNavItems.get(0).route) {
           Catfact()
        }
        composable(route = Constants.BottomNavItems.get(1).route) {
            Catfacts()
        }
        composable(route = Constants.BottomNavItems.get(2).route) {
            Hilty()
        }
    }
}

class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: String,
)



