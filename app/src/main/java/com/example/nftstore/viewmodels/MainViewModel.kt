package com.example.nftstore.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val _isLoading= MutableStateFlow(true)
    val isLoading=_isLoading
    init {
        viewModelScope.launch{
            delay(1000)
            _isLoading.value=false
        }
    }
}