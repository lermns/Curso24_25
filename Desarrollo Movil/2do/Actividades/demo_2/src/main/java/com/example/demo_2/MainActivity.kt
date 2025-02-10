package com.example.demo_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demo_2.data.dao.UserDAOImpl
import com.example.demo_2.databinding.ActivityMainBinding
import com.example.demo_2.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var operaciones: UserDAOImpl
    private val dbHelper = UserSQLiteHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operaciones = UserDAOImpl(binding.root, dbHelper)
        mostrarUsuarios().forEach{ _ -> println()}

        val user = User(name="LeBron", email="erradiquenMurcia@yahoo.com")

        binding.buttonInsertar.setOnClickListener {
            //  Resetear edit text
        //resetearEditText()
        }

        operaciones.insertarUser(user)
    }

    private fun mostrarUsuarios(): List<User> {
        return operaciones.leerUsers()
    }

    override fun onDestroy() {
        super.onDestroy()
        dbHelper.close()
    }
}