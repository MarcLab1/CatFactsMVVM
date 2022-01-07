package com.catfactscomposemvvm.ui.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.catfactscomposemvvm.repository.CatfactRepository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CatfactViewModel(private val repository: CatfactRepository) : ViewModel(){

    var catfact = mutableStateOf("")

    init {
        populateCatfact()
    }

    fun populateCatfact() : Unit
    {
        viewModelScope.launch{
            catfact.value = repository.getCatfact().fact
        }
    }
}