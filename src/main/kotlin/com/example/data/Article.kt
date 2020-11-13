package com.example.data

data class Article(
    val id: Int,
    val title: String,
    val content: String,
    val accepted: Boolean = false
)