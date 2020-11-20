package com.example.controllers

import com.example.data.MainLink
import com.example.helpers.SessionHelper
import com.example.helpers.isLogged
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute

@ControllerAdvice
class MyControllerAdvice(private val sessionHelper: SessionHelper) {

    @ModelAttribute("mainLinks")
    fun getMainLinks() =
        listOf(
            MainLink("/", "Home"),
            MainLink("/articles", "Articles")
        )

    @ModelAttribute("loggedUserLinks")
    fun getLoggedUserLinks() =
        if (sessionHelper.getSession().isLogged())
            listOf(
                MainLink("/editor/articles/add", "Add article"),
                MainLink("/reviewer/articles", "Articles to review"),
                MainLink("/admin/users", "Users"),
                MainLink("/logout", "Logout")
            )
        else
            emptyList()
}