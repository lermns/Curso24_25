package com.example.ut5_actividad5_1.model

data class User(
    var id: Int? = null,
    var name: String = "",
    var email: String = ""
) {
    override fun toString(): String {
        return "" + id + "\t\t\t\t" + name + "\t\t\t\t\t" + email
    }
}
