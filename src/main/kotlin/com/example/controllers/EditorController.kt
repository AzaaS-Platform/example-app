package com.example.controllers

import com.example.data.Article
import com.example.services.ARTICLE_ADD_PERMISSION
import com.example.services.ARTICLE_DELETE_PERMISSION
import com.example.services.PermissionsService
import com.example.services.REVIEWER_PERMISSION
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/editor")
class EditorController(private val permissionsService: PermissionsService) {

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

        //TODO add article

        return "redirect:/articles"
    }

    @GetMapping("articles/delete/{id}")
    fun articleDelete(model: Model, @PathVariable id: String): String {
        //TODO fetch article
        val article = Article(1, "Tytuł", "tekst tak o")

        if (article.accepted) {
            permissionsService.enforcePermissions(ARTICLE_DELETE_PERMISSION)
        } else {
            permissionsService.enforcePermissions(REVIEWER_PERMISSION, ARTICLE_DELETE_PERMISSION)
        }

        //TODO delete article

        return "redirect:/articles"
    }
}