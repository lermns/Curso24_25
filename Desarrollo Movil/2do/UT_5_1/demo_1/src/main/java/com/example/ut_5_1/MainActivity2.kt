package com.example.ut_5_1

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ut_5_1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)

        //  Creamos la variable que almacenara las preferencias
        val prefs = getSharedPreferences("MisPrefs", Context.MODE_PRIVATE)

        binding.switch1.isChecked = prefs.getBoolean("oscuro", false)
        binding.editTextText.setText(prefs.getFloat("tam_letra", 12F).toString())

        setContentView(binding.root)

        //  Asociar el listener al botón guardar
        binding.buttonGuardar.setOnClickListener{
            val prefss = prefs.edit()
            prefss.putBoolean("oscuro", binding.switch1.isChecked)
            prefss.putFloat("tam_letra", binding.editTextText.text.toString().toFloat())
            prefss.apply()
            finish()
        }
    }
}