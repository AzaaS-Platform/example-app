package com.example.controllers

import com.example.data.Operation
import com.example.services.DB
import com.example.services.PermissionsService
import com.example.services.REVIEWER_ACCEPT_PERMISSION
import com.example.services.REVIEWER_PERMISSION
import com.example.services.EDITOR_PERMISSION
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/reviewer")
class ReviewerController(
        private val permissionsService: PermissionsService,
        private val db: DB
) {

    @GetMapping("articles")
    fun articles(model: Model): String {
        permissionsService.enforcePermissions(EDITOR_PERMISSION)
        model["title"] = "Articles to review"
        model["articles"] = db.articles.filter { !it.accepted }
        if (permissionsService.hasPermissions(REVIEWER_PERMISSION)) {
            model["operations"] = listOf(
                    Operation("/editor/articles/delete", "DELETE"),
                    Operation("/reviewer/articles/accept", "ACCEPT")
            )
        }

        return "views/articles"
    }

    @GetMapping("articles/accept/{id}")
    fun articleAccept(model: Model, @PathVariable id: Int): String {
        permissionsService.enforcePermissions(REVIEWER_ACCEPT_PERMISSION)

        db.getArticle(id).accepted = true

        return "redirect:/reviewer/articles"
    }
}