package com.catfactscomposemvvm.ui.presentation.hilttesting

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catfactscomposemvvm.repository.CatfactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class HiltInjectionTestViewModel
@Inject constructor(
    @Named("item1") val item1: Item,
    @Named("item2") val item2: Item,
) : ViewModel() {

}