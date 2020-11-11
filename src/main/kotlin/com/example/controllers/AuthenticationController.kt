package com.example.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class AuthenticationController {

    @GetMapping("/login")
    fun login(model: Model): String {
        model["title"] = "Login"
        return "views/login"
    }

    @PostMapping("/login")
    fun login(model: Model, @RequestParam login: String, @RequestParam password: String): String {
        model["title"] = "Login"

        // TODO login

        return "views/login"
    }

    @GetMapping("/logout")
    fun logout(model: Model): String {
        // TODO logout
        return "redirect:/"
    }
}