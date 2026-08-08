package com.project.handson_1.network

import com.project.handson_1.model.ChatRequest
import com.project.handson_1.model.ChatResponse
import com.project.handson_1.utils.Constants.END_POINT
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST(END_POINT)
    suspend fun getAIResponse(
        @Body request: ChatRequest
    ): ChatResponse

}