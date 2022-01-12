package com.catfactscomposemvvm.ui.presentation.breeds

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.catfactscomposemvvm.ui.presentation.catfacts.CatfactsViewModel

@Composable
fun Breeds() {

    //var vm: CatfactsViewModel = viewModel()
    val vm = hiltViewModel<BreedsViewModel>()
    val loading = vm.loading.value
    val page = vm.page.value
    val PAGE_SIZE = 10

    LazyColumn()
    {
        itemsIndexed(vm.breedList.value)
        { index, breed ->

            vm.onChangeRecipeScrollPosition(index)
            if((index + 1) >= (page * PAGE_SIZE) && !loading){
                vm.nextPage()
            }

            Text(text = "${(index+1).toString()} -> ${breed.breed.toString()}", modifier = Modifier.padding(bottom = 10.dp))
        }
    }


}