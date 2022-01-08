package com.catfactscomposemvvm.ui.presentation.catfact

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.catfactscomposemvvm.repository.CatfactRepository
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatfactViewModel
@Inject constructor(
    private val repository: CatfactRepository
) : ViewModel() {

    var catfact = mutableStateOf("")

    init {
        populateCatfact()
    }

    fun populateCatfact(): Unit {
        viewModelScope.launch {
            catfact.value = repository.getCatfact().fact
        }
    }
}