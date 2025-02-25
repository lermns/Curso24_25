package com.example.minicalculadora

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.minicalculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var btnCheckBox: AppCompatButton
    private lateinit var btnRadioButton: AppCompatButton
    private lateinit var btnSpinner: AppCompatButton
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun manejarCliclBotones(view : View){
        //referencia de los botones
        btnCheckBox = findViewById(binding.buttonCheck.id)
        btnRadioButton = findViewById(binding.buttonRadio.id)
        btnSpinner = findViewById(binding.buttonSpinner.id)

        //utilizando la clase intent verificamos cual es el boton que se ha pulsado
        when(view.id){
            binding.buttonCheck.id -> {
                startActivity(Intent(this, CheckBox::class.java))
            }
            binding.buttonRadio.id -> {
                startActivity(Intent(this, RadioButton::class.java))
            }
            binding.buttonSpinner.id -> {
                startActivity(Intent(this, Spinner::class.java))
            }
        }


    }
}