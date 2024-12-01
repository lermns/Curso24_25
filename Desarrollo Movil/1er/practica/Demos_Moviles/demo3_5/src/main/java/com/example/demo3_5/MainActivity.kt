package com.example.demo3_5

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var imgButon : ImageButton
    private lateinit var button1 : Button
    private lateinit var button2 : Button
    private val TAG = "demo 1.0 botones"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        imgButon = findViewById(R.id.imgButton)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)

        imgButon.setOnClickListener{
            Log.d(TAG, "click boton imagen")
            Toast.makeText(this, "Boton de imagen clickeado", Toast.LENGTH_LONG).show()
        }

        button1.setOnClickListener{
            Log.d(TAG, "click boton 1")
            Toast.makeText(this, "Boton 1 clickeado", Toast.LENGTH_LONG).show()
        }

        button2.setOnClickListener{
            Log.d(TAG, "click boton 2")
            Toast.makeText(this, "Boton 2 clickeado", Toast.LENGTH_LONG).show()
        }
    }
}