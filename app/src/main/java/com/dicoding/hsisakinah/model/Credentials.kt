package com.dicoding.hsisakinah.model

data class Credentials(
    var nip: String = "",
    var password: String = "",
) {
    fun isNipEmpty(): Boolean {
        return nip.isEmpty()
    }
    fun isPasswordEmpty(): Boolean {
        return password.isEmpty()
    }
    fun isEmpty(): Boolean {
        return nip.isEmpty() && password.isEmpty()
    }
}
