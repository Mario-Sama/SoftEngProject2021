package com.example.pandaemon.ui.guidelines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuidelinesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is pandemic guidelines Fragment"
    }
    val text: LiveData<String> = _text
}