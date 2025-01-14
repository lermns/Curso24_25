package com.example.ut4_demo_3

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ut4_demo_3.databinding.ActivityMain2Binding
import com.example.ut4_demo_3.modelo.Contacto

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar2
        setSupportActionBar(toolbar)

        val contacto = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("Contacto", Contacto::class.java)
        } else {
            // Implementación para versiones anteriores a Android 13
            intent.getParcelableExtra<Contacto>("Contacto")
        }

        //contenido de recibir y mostrar los valores de los text views
        /*
        binding.nombre.text = intent.getStringExtra("NOMBRE")
        binding.telf.text = intent.getStringExtra("TELEFONO")
        binding.correo.text = intent.getStringExtra("CORREO")
        */
        binding.nombre.text = contacto?.nombre
        if (contacto != null) {
            binding.telf.text = contacto.telefono
        }
        binding.correo.text = contacto?.email

        binding.nombre.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"))
            startActivity(intent)
        }

        binding.telf.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${binding.telf.text}"))
            startActivity(intent)
        }

    }
}