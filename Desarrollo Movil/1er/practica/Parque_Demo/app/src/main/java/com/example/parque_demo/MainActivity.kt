package com.example.parque_demo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbarContador)
        setSupportActionBar(toolbar)
        toolbar.title = "Actividad_Parques"

        val editTextNombre: EditText = findViewById(R.id.editTextText3)
        val spinnerHoraApertura: Spinner = findViewById(R.id.spinner1)
        val checkBoxParqueInfantil: CheckBox = findViewById(R.id.checkBox2)
        val checkBoxZonaDeportiva: CheckBox = findViewById(R.id.checkBox)
        val checkBoxBar: CheckBox = findViewById(R.id.checkBox3)
        val buttonGuardar: Button = findViewById(R.id.button)

        buttonGuardar.setOnClickListener {
            // obtener los datos del usuario
            val nombreParque = editTextNombre.text.toString()
            val horaApertura = spinnerHoraApertura.selectedItem.toString()
            val tieneParqueInfantil = checkBoxParqueInfantil.isChecked
            val tieneZonaDeportiva = checkBoxZonaDeportiva.isChecked
            val tieneBar = checkBoxBar.isChecked

            // crear Intent para ir a la SegundaActivity
            val intent = Intent(this, SegundaActivity::class.java).apply {
                putExtra("NOMBRE_PARQUE", nombreParque)
                putExtra("HORA_APERTURA", horaApertura)
                putExtra("TIENE_PARQUE_INFANTIL", tieneParqueInfantil)
                putExtra("TIENE_ZONA_DEPORTIVA", tieneZonaDeportiva)
                putExtra("TIENE_BAR", tieneBar)
            }
            startActivity(intent)
        }
    }
}