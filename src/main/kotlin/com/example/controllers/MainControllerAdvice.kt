package com.example.controllers

import com.example.data.MainLink
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute

@ControllerAdvice
class MyControllerAdvice {

    @ModelAttribute("mainLinks")
    fun getMainLinks(): List<MainLink> {
        return listOf(MainLink("/", "Home"), MainLink("/articles", "Articles"), MainLink("/login", "Login"))
    }

    @ModelAttribute("loggedUserLinks")
    fun getLoggedUserLinks(): List<MainLink> {
        return listOf(MainLink("/articles/add", "Add article"), MainLink("/logout", "Logout"))
    }
}