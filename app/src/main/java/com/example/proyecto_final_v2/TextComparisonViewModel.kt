package com.example.proyecto_final_v2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextComparisonViewModel : ViewModel() {

    val text1 = MutableLiveData<String>()
    val text2 = MutableLiveData<String>()
    private val _comparisonResult = MutableLiveData<Boolean>()
    val comparisonResult: LiveData<Boolean>
        get() = _comparisonResult

    fun compareTexts() {
        val result = text1.value == text2.value
        _comparisonResult.postValue(result)
    }
}
