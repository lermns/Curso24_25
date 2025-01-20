package com.example.ut4_demo_4_dialog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.ut4_demo_4_dialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var boton: AppCompatButton
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener {
            val texto = "Hola. Esto es un Toast"
            val duracion = Toast.LENGTH_SHORT
//         val toast = Toast.makeText(applicationContext, texto, duracion)
//         toast.show()


            //Abreviado
            //Toast.makeText(applicationContext, texto, duracion).show()
            //Equivalente
            Toast.makeText(this, texto, duracion).show()
        }

    }
}