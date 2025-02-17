package com.example.demo_3.data.dao

import com.example.demo_3.model.User

interface UserDAO {
    fun insertarUser(user: User)
    //fun leerUsero(id: Int): User
    fun leerUsers(): List<User>
    fun actualizarUser(user: User)
    fun borrarUser(id: Int)
}