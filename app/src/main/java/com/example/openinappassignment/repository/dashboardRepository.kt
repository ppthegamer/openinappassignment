package com.example.openinappassignment.repository

import ApiResponse
import com.example.openinappassignment.network.RetrofitClient

class DashboardRepository() {

    suspend fun getDashboardData(): ApiResponse {
        val service = RetrofitClient.getInstance()
        return service.getAPIData()
    }
}