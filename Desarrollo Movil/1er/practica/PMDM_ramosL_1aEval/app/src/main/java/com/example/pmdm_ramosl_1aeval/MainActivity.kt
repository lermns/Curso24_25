package com.example.pmdm_ramosl_1aeval

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    private lateinit var btnCambiar: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnCambiar = findViewById(R.id.buttonEmpezar)
        val text1 : TextView = findViewById(R.id.editTextA)
        val text2 : TextView = findViewById(R.id.editTextB)

        btnCambiar.setOnClickListener {
            if(text1.text.toString().isEmpty() || text2.text.toString().isEmpty()){
                Toast.makeText(this, "Campos de equipos vacios", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, MainActivitySegunda::class.java)
                intent.putExtra("EQUIPOA", text1.text.toString())
                intent.putExtra("EQUIPOB", text2.text.toString())
                startActivity(intent)
            }
        }
    }
}