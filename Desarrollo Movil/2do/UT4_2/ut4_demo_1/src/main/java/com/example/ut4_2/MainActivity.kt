package com.example.ut4_2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ut4_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //  inicializamos la variable binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        //  le establecemos el contentView al root de binding
        //  similar
        //      setContentView(binding."nombre de la id que tiene el activity")
        setContentView(binding.root)

        binding.textView.text = "texto modificado"

        binding.button.setOnClickListener {
            Toast.makeText(this, "Pulsa el boton", Toast.LENGTH_LONG).show()
        }
    }
}