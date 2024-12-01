package com.example.demo3_7

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    private lateinit var btnCheckBox: AppCompatButton;
    private lateinit var btnRadioButton: AppCompatButton;
    private lateinit var btnSpinner: AppCompatButton;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    fun manejarCliclBotones(view : View){
        //referencia de los botones
        btnCheckBox = findViewById(R.id.buttonCheck)
        btnRadioButton = findViewById(R.id.buttonRadio)
        btnSpinner = findViewById(R.id.buttonSpinner)

        //utilizando la clase intent verificamos cual es el boton que se ha pulsado
        when(view.id){
            R.id.buttonCheck -> {
                startActivity(Intent(this, CheckBox::class.java))
            }
            R.id.buttonRadio -> {
                startActivity(Intent(this, RadioButton::class.java))
            }
            R.id.buttonSpinner -> {
                startActivity(Intent(this, Spinner::class.java))
            }
        }


    }
}