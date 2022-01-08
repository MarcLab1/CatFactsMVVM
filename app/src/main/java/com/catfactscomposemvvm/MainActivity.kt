package com.catfactscomposemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.catfactscomposemvvm.ui.presentation.catfact.Catfact
import com.catfactscomposemvvm.ui.presentation.catfacts.Catfacts
import com.catfactscomposemvvm.ui.theme.CatFactsComposeMVVMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //var vm: CatfactViewModel = CatfactViewModel(CatfactRepository_Impl(CatfactServiceBuilder.getCatfactService()))
        setContent {
            CatFactsComposeMVVMTheme {

                Catfacts()
            }
        }
    }
}
