package com.catfactscomposemvvm.ui.presentation.hilty

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Hilty()
{
    //var vm : HiltyViewModel = viewModel()
    val vm = hiltViewModel<HiltyViewModel>()

    Column() {

        Text(vm.repo1.service.toString())
        Text(vm.repo2.service.toString())

        Text("${vm.repo1}")
        Text("${vm.repo2}")

    }
}