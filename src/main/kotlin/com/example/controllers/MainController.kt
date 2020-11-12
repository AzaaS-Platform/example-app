package com.example.controllers

import com.example.helpers.LOGIN_KEY
import com.example.helpers.SessionHelper
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping


@Controller
class MainController(private val sessionHelper: SessionHelper) {

    @GetMapping("/")
    fun home(model: Model): String {
        model["title"] = "Home"
        model["login"] = sessionHelper.getSession().getAttribute(LOGIN_KEY) ?: ""

        return "views/home"
    }
}