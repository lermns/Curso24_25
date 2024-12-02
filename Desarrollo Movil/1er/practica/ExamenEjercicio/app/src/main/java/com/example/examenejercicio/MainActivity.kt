package com.example.examenejercicio

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    private lateinit var btnCambiar:AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnCambiar = findViewById(R.id.button)
        val text1 : TextView = findViewById(R.id.editTextText1)
        val text2 : TextView = findViewById(R.id.editTextText2)

        btnCambiar.setOnClickListener {
            val intent = Intent(this, ActivitySegunda::class.java)
            intent.putExtra("EQUIPOA", text1.text.toString())
            intent.putExtra("EQUIPOB", text2.text.toString())
            startActivity(intent)
        }
    }
}