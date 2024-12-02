package com.example.examenejercicio

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class ActivitySegunda : AppCompatActivity() {
    private lateinit var textEquip1 : TextView
    private lateinit var textEquip2 : TextView
    private lateinit var textPuntoA : TextView
    private lateinit var textPuntoB : TextView
    private lateinit var textSetA : TextView
    private lateinit var textSetB : TextView
    private lateinit var buttonPuntoA : AppCompatButton
    private lateinit var buttonPuntoB : AppCompatButton
    private lateinit var buttonReiniciar : AppCompatButton
    private lateinit var buttonCambio : AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda)
        var cont1=0
        var cont2=0
        var contSetA=0
        var contSetB=0
        textEquip1 = findViewById(R.id.textViewNombreA)
        textEquip2 = findViewById(R.id.textViewNombreB)
        textPuntoA = findViewById(R.id.textViewMarcadorA)
        textPuntoB = findViewById(R.id.textViewMarcadorB)
        textSetA = findViewById(R.id.textViewContA)
        textSetB = findViewById(R.id.textViewContB)
        buttonPuntoA = findViewById(R.id.buttonA)
        buttonPuntoB = findViewById(R.id.buttonB)
        buttonReiniciar = findViewById(R.id.buttonReiniciar)
        buttonCambio = findViewById(R.id.buttonCambioCampo)

        val nombre1 =  intent.getStringExtra("EQUIPOA")
        val nombre2 =  intent.getStringExtra("EQUIPOB")

        textEquip1.text = nombre1
        textEquip2.text = nombre2

        buttonPuntoA.setOnClickListener {
            textPuntoA.text = (++cont1).toString()
            if(cont1==3) {
                cont1 = 0
                textPuntoA.text = "0"
                textSetA.text = (++contSetA).toString()
            }
        }
        buttonPuntoB.setOnClickListener {
            textPuntoB.text = (++cont2).toString()
            if(cont2==3) {
                cont2 = 0
                textPuntoB.text = "0"
                textSetB.text = (++contSetB).toString()
            }
        }

        buttonReiniciar.setOnClickListener {
            textPuntoA.text = "0"
            textPuntoB.text = "0"
            textSetA.text = "0"
            textSetB.text = "0"
        }

        buttonCambio.setOnClickListener {
            val nombre = textEquip1.text.toString()
            textEquip1.text = textEquip2.text
            textEquip2.text = nombre

            val setPunt = textSetA.text
            textSetA.text = textSetB.text
            textSetB.text = setPunt

            textPuntoA.text = "0"
            textPuntoB.text = "0"

            val contSetChng = contSetA
            contSetA = contSetB
            contSetB = contSetChng
        }
    }
}