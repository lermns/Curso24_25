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