package com.project.handson_1.model

data class ChatRequest(
    val model: String = "llama-3.1-8b-instant",
    val messages: List<Message>
) {
    constructor(prompt: String) : this(
        messages = listOf(
            Message(
                role = "user",
                content = prompt
            )
        )
    )
}

data class Message(
    val role: String,
    val content: String
)