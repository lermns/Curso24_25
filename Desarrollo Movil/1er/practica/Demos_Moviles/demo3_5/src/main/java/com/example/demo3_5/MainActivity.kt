package com.example.demo3_5

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var imgButon : ImageButton
    private val TAG = "demo 1.0 botones"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        imgButon = findViewById(R.id.imgButton)

        imgButon.setOnClickListener{
            Log.d(TAG, "click boton imagen")
            Toast.makeText(this, "Boton de imagen clickeado", Toast.LENGTH_LONG).show()
        }

    }
}