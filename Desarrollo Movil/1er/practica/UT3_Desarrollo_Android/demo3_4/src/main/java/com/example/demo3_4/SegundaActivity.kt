package com.example.demo3_4

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SegundaActivity : AppCompatActivity() {
    private lateinit var txtMensaje : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        //  recuperamos la referencia del textView
        txtMensaje = findViewById(R.id.textMessage2)

        val mensaje = intent.getStringExtra("MENSAJE")

        txtMensaje.text = mensaje
    }
}