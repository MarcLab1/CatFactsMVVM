package com.catfactscomposemvvm.ui.presentation.catfacts

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catfactscomposemvvm.domain.Catfact
import com.catfactscomposemvvm.repository.CatfactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatfactsViewModel
@Inject constructor(
    private val repository: CatfactRepository
) : ViewModel() {

    var catfactList: MutableState<List<Catfact>> = mutableStateOf(ArrayList())
    val loading = mutableStateOf(false)
    val page = mutableStateOf(1)
    var scrollPosition = 0

    init {
        populateCatfacts()
    }

    fun populateCatfacts(): Unit {
        viewModelScope.launch { catfactList.value = repository.getCatFacts(page.value).map { it } }
    }

    fun nextPage() {
        viewModelScope.launch {

            loading.value = true
            incrementPage()

            if (page.value > 1) {
                val result = repository.getCatFacts(page.value)
                addMoreCatfacts(result)
            }
            loading.value = false
        }
    }

    private fun addMoreCatfacts(newList: List<Catfact>) {
        val current = ArrayList(this.catfactList.value)
        current.addAll(newList)
        this.catfactList.value = current
    }

    private fun incrementPage() {
        page.value = page.value + 1
    }

    fun onChangeScrollPosition(position: Int) {
        scrollPosition = position
    }
}