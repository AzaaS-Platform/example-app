package com.example.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

const val ARTICLE_ADD_PERMISSION = "editor/articles/add"
const val ARTICLE_DELETE_PERMISSION = "editor/articles/delete"
const val SECRET_ARTICLE_ADD_PERMISSION = "editor/articles/secret/add"
const val SECRET_ARTICLE_DELETE_PERMISSION = "editor/articles/secret/delete"

@Controller
@RequestMapping("/editor")
class EditorController {

    @GetMapping("articles")
    fun articles(model: Model): String {
        model["title"] = "Articles"

        //TODO add article, + add secret article

        return ""
    }

    @GetMapping("articles/add")
    fun articlesAdd(model: Model): String {
        model["title"] = "Add article"

        //TODO add article, + add secret article

        return ""
    }

    @GetMapping("articles/delete/{id}")
    fun articlesDelete(model: Model, @PathVariable id: String): String {
        //TODO delete specific article, + delete secret article

        return "redirect:/editor/articles"
    }
}