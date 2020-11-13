package com.example.controllers

import com.example.helpers.LOGIN_KEY
import com.example.helpers.SessionHelper
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.RequestDispatcher


@Controller
class MainController(private val sessionHelper: SessionHelper) : ErrorController {

    @GetMapping("/")
    fun home(model: Model): String {
        model["title"] = "Home"
        model["login"] = sessionHelper.getSession().getAttribute(LOGIN_KEY) ?: ""

        return "views/home"
    }

    @RequestMapping("/error")
    fun error(model: Model): String {
        val request = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request;

        model["title"] = "Error ${request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)}"
        model["message"] = request.getAttribute(RequestDispatcher.ERROR_MESSAGE)

        return "views/error"
    }

    override fun getErrorPath(): String {
        return "/error"
    }
}