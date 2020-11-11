package com.example.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

const val USER_LIST_PERMISSION = "admin"
const val USER_DELETE_PERMISSION = "admin/delete"

@Controller
@RequestMapping("/admin")
class AdminController {

    @GetMapping("")
    fun index(model: Model): String {
        return "redirect:/admin/users"
    }

    @GetMapping("users")
    fun users(model: Model): String {
        // TODO users list
        return ""
    }

    @GetMapping("users/delete/{id}")
    fun deleteUser(model: Model, @PathVariable id: String): String {
        // TODO delete user
        return "redirect:/admin/users"
    }
}