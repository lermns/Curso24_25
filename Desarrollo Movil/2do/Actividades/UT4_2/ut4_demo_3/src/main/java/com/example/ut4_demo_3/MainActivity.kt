package com.example.ut4_demo_3

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.widget.AppCompatButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ut4_demo_3.databinding.ActivityMainBinding
import com.example.ut4_demo_3.modelo.Contacto
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var tilNombre : TextInputLayout
    private lateinit var tilTelefono : TextInputLayout
    private lateinit var tilEmail : TextInputLayout
    private lateinit var botonAceptar: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        botonAceptar = binding.button2
        tilNombre = binding.nombre
        tilTelefono = binding.telf
        tilEmail = binding.correo

        botonAceptar.setOnClickListener {
            validarDatos()
        }
    }
    private fun validarDatos(){
        val a = validarNombre(tilNombre)
        val b = validarEmail(tilEmail)

        if (a && b) {
            Toast.makeText(this, "Abrir activity",
                Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity2::class.java)
/*
            intent.putExtra("NOMBRE", tilNombre.editText?.text.toString())
            intent.putExtra("TELEFONO", tilTelefono.editText?.text.toString())
            intent.putExtra("CORREO", tilEmail.editText?.text.toString())
 */
            val contacto = Contacto (
                tilNombre.editText?.text.toString(),
                tilTelefono.editText?.text.toString(),
                tilEmail.editText?.text.toString()
            )
            intent.putExtra("Contacto", contacto)
            startActivity(intent)
        }
    }
    private fun validarEmail(email: TextInputLayout): Boolean {
        // Comprobamos que el email encaje con el patrón de email definido por
        // la clase Patterns.
        if (!Patterns.EMAIL_ADDRESS.matcher(email.editText?.text.toString()).matches()) {
            email.error = "Correo electrónico inválido"
            return false
        } else {
            email.error = null
        }
        return true
    }


    private fun validarNombre(nombre: TextInputLayout): Boolean {
        nombre.error = null
        val cadenaNombre = nombre.editText?.text.toString()
        if (cadenaNombre.isNullOrEmpty()) {
            nombre.error = "Este campo no puede estar vacío"
            return false
        }
        if (cadenaNombre.length > 30) {
            nombre.error = "Longitud debe ser <=30"
            return false
        }
        return true
    }


}