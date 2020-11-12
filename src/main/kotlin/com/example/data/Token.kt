package com.example.data

import org.json.JSONObject
import java.util.*

class Token(val token: String) {
    val exp: Long

    init {
        val payload = JSONObject(Base64.getDecoder().decode(token).toString().split(".")[1])
        this.exp = payload.getLong("exp")
    }

    val isActive: Boolean
        get() = System.currentTimeMillis() / 1000 < exp
}