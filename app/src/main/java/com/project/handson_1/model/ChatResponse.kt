package com.project.handson_1.model

data class ChatResponse(
    val choices: List<Choice>
) {
    val response: String
        get() = choices.firstOrNull()?.message?.content ?: "No response received"
}

data class Choice(
    val message: MessageResponse
)

data class MessageResponse(
    val role: String,
    val content: String
)