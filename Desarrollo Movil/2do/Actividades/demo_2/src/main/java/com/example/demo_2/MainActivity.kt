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
        val user = User(name="LeBron", email="erradiquenMurcia@yahoo.com")
        operaciones.insertarUser(user)
    }
}