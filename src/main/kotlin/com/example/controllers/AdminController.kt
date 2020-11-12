package com.example.controllers

import com.example.data.User
import com.example.helpers.PermissionsHelper
import com.example.helpers.USER_DELETE_PERMISSION
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin")
class AdminController(private val permissionsHelper: PermissionsHelper) {

    @GetMapping
    fun index(model: Model) = "redirect:/admin/users"

    @GetMapping("users")
    fun users(model: Model): String {
        model["title"] = "Users"

        // TODO users list
        model["users"] = listOf(User("ide", "user"))
        if (permissionsHelper.hasPermissions(USER_DELETE_PERMISSION)) {
            model["showDelete"] = true
        }

        return "views/users"
    }

    @GetMapping("users/delete/{id}")
    fun deleteUser(model: Model, @PathVariable id: String): String {
        // TODO delete user
        return "redirect:/admin/users"
    }
}