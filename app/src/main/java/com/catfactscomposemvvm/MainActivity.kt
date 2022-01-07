package com.catfactscomposemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.catfactscomposemvvm.network.RetrofitService
import com.catfactscomposemvvm.network.RetrofitServiceBuilder
import com.catfactscomposemvvm.repository.CatfactRepository
import com.catfactscomposemvvm.ui.presentation.Catfact
import com.catfactscomposemvvm.ui.presentation.CatfactViewModel
import com.catfactscomposemvvm.ui.theme.CatFactsComposeMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var vm: CatfactViewModel = CatfactViewModel(CatfactRepository(RetrofitServiceBuilder.getRetrofitService()))
        setContent {
            CatFactsComposeMVVMTheme {

                Catfact(vm)
            }
        }
    }
}
