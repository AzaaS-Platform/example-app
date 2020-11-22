package com.example.controllers

import com.example.services.AuthenticationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class AuthenticationController(private val authenticationService: AuthenticationService) {

    @GetMapping("/login")
    fun loginWtf(): String {
        return "redirect:/"
    }

    @PostMapping("/login")
    fun login(@RequestParam token: String): String {
        authenticationService.login(token)

        return "redirect:/"
    }

    @GetMapping("/logout")
    fun logout(model: Model): String {
        authenticationService.logout()

        return "redirect:/"
    }
}