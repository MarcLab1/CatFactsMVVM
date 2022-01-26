package com.catfactscomposemvvm.ui.presentation.catfacts

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Catfacts() {

    //var vm: CatfactsViewModel = viewModel()
    val vm = hiltViewModel<CatfactsViewModel>()
    val loading = vm.loading.value
    val page = vm.page.value
    val PAGE_SIZE = 10

    //Text(vm.networkSearches.toString())

    LazyColumn( modifier = Modifier.padding(bottom = 50.dp))
    {

        itemsIndexed(vm.catfactList.value)
        { index, catfact ->

            vm.onChangeScrollPosition(index)
            if ((index + 1) >= (page * PAGE_SIZE) && !loading) {
                vm.nextPage()
            }

            Text(
                text = "${(index + 1)} -> ${catfact.fact}",
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }
    }


}