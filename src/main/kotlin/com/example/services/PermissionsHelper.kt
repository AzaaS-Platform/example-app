package com.example.services

import com.example.exceptions.PermissionException


const val USER_LIST_PERMISSION = "admin"
const val USER_DELETE_PERMISSION = "admin/delete"
const val ARTICLE_ADD_PERMISSION = "editor/articles/add"
const val ARTICLE_DELETE_PERMISSION = "editor/articles/delete"
const val SECRET_ARTICLES_PERMISSION = "articles/secret"
const val SECRET_ARTICLE_ADD_PERMISSION = "editor/articles/secret/add"
const val SECRET_ARTICLE_DELETE_PERMISSION = "editor/articles/secret/delete"

class PermissionsHelper {

    fun enforcePermissions(vararg permissions: String) {
        if (!hasPermissions(*permissions)) throw PermissionException("You are not permitted to perform this action")
    }

    fun hasPermissions(vararg permissions: String): Boolean {
        //TODO permissions match
        return true
    }
}