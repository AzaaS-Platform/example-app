package com.example.services

import com.example.helpers.APIConnector
import com.example.helpers.SessionHelper
import com.example.helpers.getToken
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException


const val ADMIN_USERS_PERMISSION = "admin/users"

const val ARTICLE_ADD_PERMISSION = "editor/articles/add"
const val ARTICLE_DELETE_PERMISSION = "editor/articles/delete"

const val REVIEWER_ACCEPT_PERMISSION = "reviewer/articles/accept"
const val REVIEWER_DELETE_PERMISSION = "reviewer/articles/delete"
const val REVIEWER_LIST_PERMISSION = "reviewer/articles/list"
const val REVIEWER_GET_PERMISSION = "reviewer/articles/get"

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