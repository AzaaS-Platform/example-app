package com.example.controllers

import com.example.data.Article
import com.example.services.ARTICLE_DELETE_PERMISSION
import com.example.services.PermissionsHelper
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/articles")
class ArticlesController(private val permissionsHelper: PermissionsHelper) {

    @GetMapping
    fun articles(model: Model): String {
        model["title"] = "Articles"

        //TODO articles list, + secret articles if logged
        model["articles"] = listOf(Article(1, "Tytuł", "tekst tak o"))
        if (permissionsHelper.hasPermissions(ARTICLE_DELETE_PERMISSION)) {
            model["showDelete"] = true
        }

        return "views/articles"
    }

    @GetMapping("{id}")
    fun article(model: Model, @PathVariable id: String): String {
        model["title"] = "<article_title>"

        //TODO specific article, + secret article if logged
        model["article"] = listOf(Article(1, "Tytuł", "tekst tak o"))

        return "views/article"
    }
}