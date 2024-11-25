package com.example.demo3_4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var txtMessage : EditText
    private lateinit var btnEnviar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // obtiene la referencia de los controles para usarlos dentro del activity
        txtMessage = findViewById(R.id.txtMessage)
        btnEnviar = findViewById(R.id.botonEnviar)

        btnEnviar.setOnClickListener {
            val intent = Intent(this, SegundaActivity::class.java)

            intent.putExtra("MENSAJE", txtMessage.text.toString())

            startActivity(intent)
        }
    }
}