package com.example.demo_2.data.dao

import com.example.demo_2.model.User

interface UsuarioDAO {
    fun insertarUser(user: User)
    fun leerUsero(id: Int): User
    fun leerUsers(): List<User>
    fun actualizarUser(user: User)
    fun borrarUser(id: Int)
}