package com.project.handson_1.repository

import org.json.JSONObject
import com.project.handson_1.model.ChatRequest
import com.project.handson_1.network.ApiClient
import retrofit2.HttpException

class AIRepository {

    suspend fun askAI(prompt: String): String {

        return try {

            val response = ApiClient.apiService.getAIResponse(
                ChatRequest(prompt)
            )

            response.response

        } catch (e: HttpException) {

            val errorBody = e.response()?.errorBody()?.string()
            val errorMessage = try {
                val json = JSONObject(errorBody ?: "")
                json.getJSONObject("error").getString("message")
            } catch (jsonEx: Exception) {
                null
            }
            "Error : ${errorMessage ?: e.message()}"

        } catch (e: Exception) {

            "Error : ${e.message}"

        }

    }

}