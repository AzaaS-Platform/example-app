package com.example.controllers

import com.example.data.Article
import com.example.data.Operation
import com.example.services.PermissionsService
import com.example.services.REVIEWER_PERMISSION
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/reviewer")
class ReviewerController(private val permissionsService: PermissionsService) {

    @GetMapping("articles")
    fun articles(model: Model): String {
        permissionsService.enforcePermissions(REVIEWER_PERMISSION)

        model["title"] = "Articles to review"
        //TODO fetch articles
        model["articles"] = emptyList<Article>()
        model["operations"] = listOf(
            Operation("/editor/articles/delete", "DELETE"),
            Operation("/reviewer/articles/accept", "ACCEPT")
        )

        return "views/articles"
    }
}