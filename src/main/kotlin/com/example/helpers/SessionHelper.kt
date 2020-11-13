package com.example.helpers

import com.example.data.Token
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpSession

const val LOGIN_KEY = "login"
const val TOKEN_KEY = "token"

class SessionHelper {

    fun getSession(): HttpSession =
        (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request.getSession(true)
}

fun HttpSession.isLogged() = getToken()?.isActive ?: false

fun HttpSession.getToken() = getAttribute(TOKEN_KEY) as Token?