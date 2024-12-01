package com.example.demo3_8

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar

class MostrarContadorActivity : AppCompatActivity() {
    private lateinit var contadorTextView: TextView
    private lateinit var btnClose: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mostrar_contador)

        val toolbar = findViewById<Toolbar>(R.id.toolbarContador)
        setSupportActionBar(toolbar)
        toolbar.title = "Activity Contador"

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        val contador = intent.getIntExtra("CONTADOR", 0)

        contadorTextView = findViewById(R.id.muestraContador)
        contadorTextView.text = contador.toString()

        btnClose = findViewById(R.id.btnClose)
        btnClose.setOnClickListener {
               finish()
        }
    }
}