package com.example.signin.navigation

sealed class NavRoute(val path: String) {
    object Login: NavRoute(path = "login")
    object Sign: NavRoute(path = "sign")
    object Profile: NavRoute("profile") {
        val id = "id"
        val showDetails = "showDetails"
    }
    object Search: NavRoute("search") {
        val query = "query"
    }

    fun withArgs(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }
    fun withArgsFormat(vararg args: String) : String {
        return buildString {
            append(path)
            args.forEach{ arg ->
                append("/{$arg}")
            }
        }
    }
}