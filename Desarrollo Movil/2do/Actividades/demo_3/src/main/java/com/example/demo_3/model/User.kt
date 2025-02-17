package com.example.demo_3.model

data class User(
    var id: Int? = null,
    var name: String = "",
    var email: String = ""
) {
    override fun toString(): String {
        return "" + id + "\t\t\t\t" + name + "\t\t\t\t\t" + email
    }
}
