package com.example.controllers

import com.example.services.ADMIN_USERS_PERMISSION
import com.example.services.AdminService
import com.example.services.PermissionsService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin")
class AdminController(
    private val permissionsService: PermissionsService,
    private val adminService: AdminService
) {

    @GetMapping
    fun index(model: Model) = "redirect:/admin/users"

    @GetMapping("users")
    fun users(model: Model): String {
        permissionsService.enforcePermissions(ADMIN_USERS_PERMISSION)

        model["title"] = "Users"
        model["users"] = adminService.getUsers()

        return "views/users"
    }
}