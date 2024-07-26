package com.example.openinappassignment.network

import ApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIService{

@GET("dashboardNew")
@Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI")
suspend fun getAPIData():ApiResponse

}