package com.example.openinappassignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.openinappassignment.repository.DashboardRepository
import com.example.openinappassignment.viewmodels.DashboardViewModel

class MainViewModelFactory(private val repository: DashboardRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(DashboardViewModel::class.java)){
            return DashboardViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}