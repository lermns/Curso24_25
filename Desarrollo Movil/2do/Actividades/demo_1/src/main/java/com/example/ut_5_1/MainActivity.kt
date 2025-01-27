package com.example.ut_5_1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.ut_5_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.text = "Las ideas que comunica un texto están contenidas en lo que se suele denominar " +
                "«macroproposiciones», unidades estructurales de nivel superior o global, que otorgan coherencia " +
                "al texto constituyendo su hilo central, el esqueleto estructural que cohesiona elementos lingüísticos " +
                "formales de alto nivel, como los títulos y subtítulos, la secuencia de párrafos, etc. En contraste, las " +
                "«microproposiciones» son los elementos coadyuvantes de la cohesión de un texto, pero a nivel más particular o" +
                " local. Esta distinción fue realizada por Teun van Dijk en 1980.1"

        binding.button.setOnClickListener{
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        leerPreferencias()
    }

    private fun leerPreferencias(){
        val prefs = getSharedPreferences("MisPrefs", Context.MODE_PRIVATE)
        binding.textView.textSize = prefs.getFloat("tam_letra", 12F)

        if(prefs.getBoolean("oscuro", false)){
            // Establecemos el modo noche en la aplicación
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}