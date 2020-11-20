package com.example.controllers

import com.example.data.Article
import com.example.services.*
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/editor")
class EditorController(
    private val permissionsService: PermissionsService,
    private val db: DB
) {

    @GetMapping("articles/add")
    fun articleAddForm(model: Model): String {
        permissionsService.enforcePermissions(ARTICLE_ADD_PERMISSION)

        model["title"] = "Add article"

        return "views/articleAdd"
    }

    @PostMapping("articles/add")
    fun articleAdd(model: Model, @RequestParam title: String, @RequestParam content: String): String {
        permissionsService.enforcePermissions(ARTICLE_ADD_PERMISSION)

        model["title"] = "Add article"

        db.addArticle(Article(db.nextIndex, title, content))

        return "redirect:/reviewer/articles"
    }

    @GetMapping("articles/delete/{id}")
    fun articleDelete(model: Model, @PathVariable id: Int): String {
        val article = db.getArticle(id)

        if (article.accepted) {
            permissionsService.enforcePermissions(ARTICLE_DELETE_PERMISSION)
        } else {
            permissionsService.enforcePermissions(REVIEWER_DELETE_PERMISSION, ARTICLE_DELETE_PERMISSION)
        }

        db.removeArticle(id)

        return "redirect:/articles"
    }
}