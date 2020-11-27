package com.example.services

import com.example.data.Token
import com.example.helpers.*
import org.springframework.http.HttpStatus
import org.springframework.session.MapSessionRepository
import org.springframework.web.server.ResponseStatusException

class AuthenticationService(
    private val sessionHelper: SessionHelper,
    private val apiConnector: APIConnector,
    private val sessionRepository: MapSessionRepository
) {

    fun login(token: String) {
        val tokenObject = Token(token)
        if (tokenObject.client != CLIENT_ID) throw ResponseStatusException(
            HttpStatus.UNAUTHORIZED,
            "Your token is not valid"
        )

        val login = apiConnector.getSelfUsername(token, tokenObject.userId)
        sessionHelper.getSession().setAttribute(TOKEN_KEY, tokenObject)
        sessionHelper.getSession().setAttribute(LOGIN_KEY, login)
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