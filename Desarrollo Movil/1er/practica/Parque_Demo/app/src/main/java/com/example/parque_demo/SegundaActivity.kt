package com.example.parque_demo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda)

        val textView: TextView = findViewById(R.id.textViewMessage)

        // recuperar los datos enviados desde el main
        val parque = intent.getStringExtra("NOMBRE_PARQUE")
        val horaApertura = intent.getStringExtra("HORA_APERTURA")
        val tieneParqueInfantil = intent.getBooleanExtra("TIENE_PARQUE_INFANTIL", false)
        val tieneZonaDeportiva = intent.getBooleanExtra("TIENE_ZONA_DEPORTIVA", false)
        val tieneBar = intent.getBooleanExtra("TIENE_BAR", false)

        // construir el mensaje inicial
        val mensaje = StringBuilder().apply {
            append("El parque $parque abre a las $horaApertura y ")
            append(if (tieneParqueInfantil) "tiene parque infantil." else "no tiene parque infantil.")

            // agregar las actividades disponibles, solo si están marcadas
            append("\nActividades disponibles: ")
            val actividades = mutableListOf<String>()
            if (tieneZonaDeportiva) actividades.add("zona deportiva")
            if (tieneBar) actividades.add("bar")

            // si hay actividades, añadirlas al mensaje
            if (actividades.isNotEmpty()) {
                append(actividades.joinToString(", "))
            } else {
                append("No hay actividades seleccionadas.")
            }
        }.toString()

        // mostrar el mensaje en el TextView
        textView.text = mensaje
    }
}