package com.example.ut5_actividad5_1.dao

import com.example.ut5_actividad5_1.model.User

interface UserDAO {
    fun insertarUser(user: User)
    //fun leerUsero(id: Int): User
    fun leerUsers(): List<User>
    fun actualizarUser(user: User)
    fun borrarUser(id: Int)
    fun borrarTodoUsers()
}