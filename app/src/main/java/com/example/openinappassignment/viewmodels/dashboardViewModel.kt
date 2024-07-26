package com.example.openinappassignment.viewmodels

import ApiResponse
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openinappassignment.repository.DashboardRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel(val repository: DashboardRepository):ViewModel() {
val _dashboardData = MutableStateFlow<List<ApiResponse>> (emptyList())
    val dashboardData :StateFlow<List<ApiResponse>> get() = _dashboardData


    fun getDashboardData(){
        viewModelScope.launch {
            try {
                val data =repository.getDashboardData()
                _dashboardData.value= listOf(data)
            }catch (e: Exception) {
                Log.d("asdfasdf ", e.message.toString())
            }
        }
    }
}