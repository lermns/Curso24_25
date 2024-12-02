package com.example.myapplication

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editTxt1:EditText = findViewById(R.id.editText1)
        val editTxt2:EditText = findViewById(R.id.editText2)
        val boton:AppCompatButton = findViewById(R.id.button)

        boton.setOnClickListener{
            editTxt2.text = editTxt1.text
        }
    }
}