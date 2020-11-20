package com.example.services

import com.example.data.Token
import com.example.helpers.APIConnector
import com.example.helpers.SessionHelper
import com.example.helpers.TOKEN_KEY
import com.example.helpers.getToken
import org.springframework.session.MapSessionRepository

class AuthenticationService(
    private val sessionHelper: SessionHelper,
    private val apiConnector: APIConnector,
    private val sessionRepository: MapSessionRepository
) {

    fun login(token: String) {
        sessionHelper.getSession().setAttribute(TOKEN_KEY, Token(token))
    }

    fun logout() {
        val token = sessionHelper.getSession().getToken()
        if (token != null) {
            apiConnector.invalidateToken(token.value)
            sessionHelper.getSession().removeAttribute(TOKEN_KEY)
            sessionRepository.deleteById(sessionHelper.getSession().id)
        }
    }
}