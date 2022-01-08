package com.catfactscomposemvvm.ui.presentation.catfacts

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catfactscomposemvvm.domain.Catfact
import com.catfactscomposemvvm.repository.CatfactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatfactsViewModel
@Inject constructor(
    private val repository: CatfactRepository
) : ViewModel() {

    var catfactList: MutableState<List<String>> = mutableStateOf(ArrayList())

    init {
        populateCatfacts()
    }

    fun populateCatfacts(): Unit {

        viewModelScope.launch { catfactList.value = repository.getCatFacts().map { it.fact } }

    }

}