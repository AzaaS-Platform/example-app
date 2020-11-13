package com.example.services

import com.example.data.Token
import com.example.helpers.*
import org.springframework.session.MapSessionRepository

class AuthenticationService(
    private val sessionHelper: SessionHelper,
    private val apiConnector: APIConnector,
    private val sessionRepository: MapSessionRepository
) {

    fun login(login: String, password: String) {
        val session = sessionHelper.getSession()
        session.setAttribute(TOKEN_KEY, Token(apiConnector.authenticateUser(login, password)))
        session.setAttribute(LOGIN_KEY, login)
    }

    fun logout() {
        apiConnector.invalidateToken(sessionHelper.getSession().getToken()!!.value)
        sessionHelper.getSession().removeAttribute(TOKEN_KEY)
        sessionHelper.getSession().removeAttribute(LOGIN_KEY)
        sessionRepository.deleteById(sessionHelper.getSession().id)
    }
}