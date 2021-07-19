package com.example.secondkotlin.viewmodel.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.secondkotlin.viewmodel.model.MyViewModel

class MyFragmentViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)){
            return MyViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}