package com.example.ramosl_pmdm_examen_2aeval

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.ramosl_pmdm_examen_2aeval.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.main)
        // Obtenemos una referencia a la Toolbar y la asignamos a la Activity
        val toolbar = findViewById<Toolbar>(R.id.toolbarContador)
        setSupportActionBar(toolbar)
        // Cambiamos el título
        toolbar.title = "Listado"

        // ---------   Habilitar botón 'Atrás' en Toolbar   -----------
        toolbar.setNavigationIcon(R.drawable.ic_atras)

        // Establecemos el listener del botón atrás
        toolbar.setNavigationOnClickListener {
            // Termina la activity actual y vuelve a la MainActivity
            finish()
        }
        // ---------   Fin Habilitar botón 'Atrás' en Toolbar   -----------

        val mensaje =intent.getStringExtra("MENSAJE")
        binding.textViewMascotas.text = mensaje
    }
}