package com.example.services

import com.example.data.User
import com.example.helpers.APIConnector
import com.example.helpers.SessionHelper
import com.example.helpers.getToken
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class AdminService(
    private val apiConnector: APIConnector,
    private val sessionHelper: SessionHelper
) {

    fun getUsers(): List<User> = apiConnector.getUsers(
        sessionHelper.getSession().getToken()?.value ?: throw ResponseStatusException(
            HttpStatus.FORBIDDEN,
            "Your session has expired"
        )
    )
}