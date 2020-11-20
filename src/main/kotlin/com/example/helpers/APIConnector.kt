package com.example.helpers

import com.example.data.User
import khttp.get
import khttp.post
import org.json.JSONArray
import org.json.JSONObject

const val CLIENT_ID = "exampleapp"
const val API_BASE_URL = "https://cgk3n01fd7.execute-api.eu-central-1.amazonaws.com/prod"
const val API_CLIENT_URL = "$API_BASE_URL/clients/$CLIENT_ID"

class APIConnector {

    fun invalidateToken(token: String): Boolean = get(
        "$API_BASE_URL/token/invalidate",
        headers = mapOf(
            "Authorization" to "Bearer $token"
        )
    ).statusCode == 200

    fun authorize(token: String, vararg permissions: String): Boolean = post(
        "$API_BASE_URL/authorize", data = JSONObject(
            mapOf(
                "requiredPermissions" to JSONArray(permissions)
            )
        ),
        headers = mapOf(
            "Authorization" to "Bearer $token"
        )
    ).statusCode == 200

    fun refreshToken(token: String): String = get(
        "$API_BASE_URL/token",
        headers = mapOf(
            "Authorization" to "Bearer $token"
        )
    ).jsonObject.getJSONObject("payload").getString("token")

    fun getUsers(token: String): List<User> = get(
        "$API_CLIENT_URL/users",
        headers = mapOf(
            "Authorization" to "Bearer $token"
        )
    ).jsonObject.getJSONArray("payload").map {
        it as JSONObject
        User(it.getString("entity"), it.getString("username"))
    }
}