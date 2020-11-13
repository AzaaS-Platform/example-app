package com.example.services

import com.example.helpers.APIConnector
import com.example.helpers.SessionHelper
import com.example.helpers.getToken
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException


const val ADMIN_PERMISSION = "admin"

const val EDITOR_PERMISSION = "editor"
const val ARTICLE_ADD_PERMISSION = "$EDITOR_PERMISSION/articles/add"
const val ARTICLE_DELETE_PERMISSION = "$EDITOR_PERMISSION/articles/delete"

const val REVIEWER_PERMISSION = "reviewer"
const val REVIEWER_ACCEPT_PERMISSION = "$REVIEWER_PERMISSION/accept"

class PermissionsService(
    private val apiConnector: APIConnector,
    private val sessionHelper: SessionHelper
) {

    fun enforcePermissions(vararg permissions: String) {
        if (!hasPermissions(*permissions)) throw ResponseStatusException(
            HttpStatus.FORBIDDEN,
            "You are not permitted to perform this action"
        )
    }

    fun hasPermissions(vararg permissions: String): Boolean {
        return apiConnector.authorize(
            sessionHelper.getSession().getToken()?.value ?: return false
            , *permissions
        )
    }
}