package com.catfactscomposemvvm.ui.presentation.hilty

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class HiltyViewModel
@Inject constructor(
@Named("repo1") var repo1: Repo,
@Named("repo1") var repo2: Repo)
: ViewModel() {

}