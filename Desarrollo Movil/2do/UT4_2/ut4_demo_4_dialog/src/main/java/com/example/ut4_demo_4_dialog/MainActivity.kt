package com.example.ut4_demo_4_dialog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ut4_demo_4_dialog.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener {
            val texto = "Hola. Esto es un Toast"
            val duracion = Toast.LENGTH_SHORT

            Toast.makeText(this, texto, duracion).show()
        }

        binding.btnMostrarSnackbar.setOnClickListener {
            val texto = "Hola. Esto es un SnackBar"
            val duracion = Toast.LENGTH_SHORT

            Snackbar.make(binding.root, texto, duracion).show()
        }

        binding.btnAccion.setOnClickListener {
            val texto = "Hola. Esto es un SnackBarAction"
            val duracion = Toast.LENGTH_LONG

            //Snackbar.make(binding.root, texto, duracion).show()
            Snackbar.make(binding.root, texto, duracion).show()
        }
    }
}