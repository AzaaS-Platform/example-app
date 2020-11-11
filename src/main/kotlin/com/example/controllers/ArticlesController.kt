package com.example.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

const val SECRET_ARTICLES_PERMISSION = "articles/secret"

@Controller
@RequestMapping("/articles")
class ArticlesController {

    @GetMapping("")
    fun articles(model: Model): String {
        model["title"] = "Articles"

        //TODO articles list, + secret articles if logged

        return ""
    }

    @GetMapping("{id}")
    fun article(model: Model, @PathVariable id: String): String {
        model["title"] = "<article_title>"

        //TODO specific article, + secret article if logged

        return ""
    }
}