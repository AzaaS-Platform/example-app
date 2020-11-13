package com.example.controllers

import com.example.data.Article
import com.example.data.Operation
import com.example.services.ARTICLE_DELETE_PERMISSION
import com.example.services.PermissionsService
import com.example.services.REVIEWER_PERMISSION
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/articles")
class ArticlesController(private val permissionsService: PermissionsService) {

    @GetMapping
    fun articles(model: Model): String {
        model["title"] = "Articles"

        //TODO fetch articles
        model["articles"] = listOf(Article(1, "Tytuł", "tekst tak o"))
        if (permissionsService.hasPermissions(ARTICLE_DELETE_PERMISSION)) {
            model["operations"] = listOf(Operation("/editor/articles/delete", "DELETE"))
        }

        return "views/articles"
    }

    @GetMapping("{id}")
    fun article(model: Model, @PathVariable id: String): String {
        //TODO fetch article
        val article = Article(1, "Tytuł", "tekst tak o")

        if (!article.accepted) permissionsService.enforcePermissions(REVIEWER_PERMISSION)

        model["title"] = article.title
        model["article"] = article

        return "views/article"
    }
}