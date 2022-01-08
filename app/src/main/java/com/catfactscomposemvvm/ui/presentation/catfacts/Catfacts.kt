package com.catfactscomposemvvm.ui.presentation.catfacts

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Catfacts() {
    var vm: CatfactsViewModel = viewModel()

    LazyColumn()
    {
        items(vm.catfactList.value)
        { catfact ->
            Text(text = catfact, modifier = Modifier.padding(bottom = 10.dp))
        }
    }


}