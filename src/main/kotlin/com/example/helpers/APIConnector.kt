package com.example.helpers

import com.example.data.User
import khttp.get
import khttp.post
import org.json.JSONObject

const val CLIENT_ID = "exampleapp"
const val API_BASE_URL = "https://cgk3n01fd7.execute-api.eu-central-1.amazonaws.com/prod"
const val API_CLIENT_URL = "$API_BASE_URL/clients/$CLIENT_ID"

class APIConnector {

    fun authenticateUser(login: String, password: String): String = post(
        "$API_CLIENT_URL/token", data = JSONObject(
            mapOf(
                "username" to login,
                "password" to password
            )
        )
    ).jsonObject.getJSONObject("payload").getString("token")

    fun authorize(vararg permissions: String): Boolean = post(
        "$API_BASE_URL/authorize", data = JSONObject(
            mapOf(
                "requiredPermissions" to permissions.toString()
            )
        )
    ).statusCode == 200

    fun refreshToken(): String = get("$API_BASE_URL/token").jsonObject.getJSONObject("payload").getString("token")

    fun getUsers(): List<User> = get("$API_CLIENT_URL/users").jsonObject.getJSONArray("payload").map {
        it as JSONObject
        User(it.getString("entity"), it.getString("username"))
    }
}