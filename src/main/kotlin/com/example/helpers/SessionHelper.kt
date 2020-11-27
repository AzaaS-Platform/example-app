package com.example.helpers

import com.example.data.Token
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpSession

const val TOKEN_KEY = "token"
const val LOGIN_KEY = "login"

class SessionHelper {

    fun getSession(): HttpSession =
        (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request.getSession(true)
}

fun HttpSession.isLogged() = getToken()?.isActive ?: false

fun HttpSession.getToken() = getAttribute(TOKEN_KEY) as Token?

fun HttpSession.getLogin() = (getAttribute(LOGIN_KEY) as String?) ?: ""