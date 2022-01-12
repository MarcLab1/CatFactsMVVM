package com.catfactscomposemvvm.ui.presentation.breeds

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catfactscomposemvvm.domain.Breed
import com.catfactscomposemvvm.domain.Catfact
import com.catfactscomposemvvm.repository.CatfactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedsViewModel
@Inject constructor(
    private val repository: CatfactRepository
) : ViewModel() {

    var breedList: MutableState<List<Breed>> = mutableStateOf(ArrayList())
    val loading = mutableStateOf(false)
    val page = mutableStateOf(1)
    var recipeListScrollPosition = 0

    init {
        populateCatfacts()
    }

    fun populateCatfacts(): Unit {
        viewModelScope.launch { breedList.value = repository.getBreeds(page.value).map { it } }
    }

    fun nextPage(){
        viewModelScope.launch {
            loading.value = true
            incrementPage()

            if (page.value > 1) {
                val result = repository.getBreeds(page.value)
                addMoreBreeds(result)
            }
            loading.value = false
        }
    }

    private fun addMoreBreeds(newList : List<Breed>){
        val current = ArrayList(this.breedList.value)
        current.addAll(newList)
        this.breedList.value = current
    }

    private fun incrementPage(){
        page.value = page.value + 1
    }

    fun onChangeRecipeScrollPosition(position: Int){
        recipeListScrollPosition = position
    }


}