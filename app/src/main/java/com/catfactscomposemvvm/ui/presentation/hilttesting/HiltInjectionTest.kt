package com.catfactscomposemvvm.ui.presentation.hilttesting

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HiltInjectionTest() {
    //var vm: HiltInjectionTestViewModel = viewModel()
    val vm = hiltViewModel<HiltInjectionTestViewModel>()

    Column() {
        Text("${vm.item1}")
       // Text("${vm.item2}")
        Text("${vm.item2}")
    }
}