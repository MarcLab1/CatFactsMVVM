package com.catfactscomposemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.catfactscomposemvvm.ui.presentation.MyBottomNavigation
import com.catfactscomposemvvm.ui.presentation.catfact.Catfact
import com.catfactscomposemvvm.ui.presentation.catfact.CatfactViewModel
import com.catfactscomposemvvm.ui.presentation.catfacts.Catfacts
import com.catfactscomposemvvm.ui.presentation.hilttesting.HiltInjectionTest
import com.catfactscomposemvvm.ui.presentation.hilty.Hilty
import com.catfactscomposemvvm.ui.theme.CatFactsComposeMVVMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //var vm: CatfactViewModel = CatfactViewModel(CatfactRepository_Impl(CatfactServiceBuilder.getCatfactService()))
        setContent {
            CatFactsComposeMVVMTheme {
                MyBottomNavigation()
            }
        }
    }
}


