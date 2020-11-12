package com.example.controllers

import com.example.helpers.PermissionsHelper
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/editor")
class EditorController(val permissionsHelper: PermissionsHelper) {

    @GetMapping("articles/add")
    fun articleAddForm(model: Model): String {
        model["title"] = "Add article"

        //TODO add article, + add secret article

        return "views/articleAdd"
    }

    @PostMapping("articles/add")
    fun articleAdd(model: Model, @RequestParam title: String, @RequestParam content: String): String {
        model["title"] = "Add article"

        //TODO add article, + add secret article

        return "redirect:/articles"
    }

    @GetMapping("articles/delete/{id}")
    fun articleDelete(model: Model, @PathVariable id: String): String {
        //TODO delete specific article, + delete secret article

        return "redirect:/articles"
    }
}