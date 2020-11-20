package com.example.data

import org.json.JSONObject
import java.util.*

const val MAX_MINUTES_TILL_EXPIRE = 5

class Token(token: String) {
    val value: String = token
    val client: String
    private val exp: Long

    init {
        val payload = JSONObject(String(Base64.getDecoder().decode(token.split(".")[1])))
        this.exp = payload.getLong("exp")
        client = payload.getString("clt")
    }

    val isAboutToExpire: Boolean
        get() = System.currentTimeMillis() / 1000 + MAX_MINUTES_TILL_EXPIRE * 60 > exp

    val isActive: Boolean
        get() = System.currentTimeMillis() / 1000 < exp
}