package com.example.controllers

import com.example.services.AuthenticationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class AuthenticationController(private val authenticationService: AuthenticationService) {

    @GetMapping("/login")
    fun login(model: Model): String {
        model["title"] = "Login"

        return "views/login"
    }

    @PostMapping("/login")
    fun login(@RequestParam login: String, @RequestParam password: String): String {
        authenticationService.login(login, password)

        return "redirect:/"
    }

    @GetMapping("/logout")
    fun logout(model: Model): String {
        authenticationService.logout()

        return "redirect:/"
    }
}