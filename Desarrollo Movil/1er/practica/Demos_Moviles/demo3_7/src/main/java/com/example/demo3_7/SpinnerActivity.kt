package com.example.demo3_7

import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar

class SpinnerActivity : AppCompatActivity() {
    private lateinit var btnCalcular: AppCompatButton
    private lateinit var etNum1: EditText
    private lateinit var etNum2: EditText
    private lateinit var tvResultado: TextView
    private lateinit var operacion: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinner)
        val toolbar = findViewById<Toolbar>(R.id.spToolbar)
        setSupportActionBar(toolbar)

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        btnCalcular = findViewById(R.id.buttonSpiners)
        etNum1 = findViewById(R.id.editTextSpiner1)
        etNum2 = findViewById(R.id.editTextSpiner2)
        tvResultado = findViewById(R.id.textViewSpiner)
        operacion = findViewById(R.id.spinner)

        // lambda del listener
        btnCalcular.setOnClickListener {

            val num1String = etNum1.text.toString()
            val num2String = etNum2.text.toString()

            // Validamos que los EditText no estén vacíos
            if (num1String.trim().isNotEmpty() && num2String.trim().isNotEmpty()) {
                //  En caso de que tenga valores nulos o letras este le asigna 0 por defecto para evitar que
                //  el programa casque
                val num1 = num1String.toDoubleOrNull()?:0.00
                val num2 = num2String.toDoubleOrNull()?:0.00

                when (operacion.selectedItem.toString()) {
                    "Sumar" -> tvResultado.text = "Suma = ${num1 + num2}"
                    "Restar" -> tvResultado.text = "Resta = ${num1 - num2}"

                    else -> {
                        Toast.makeText(this,
                            "Debes seleccionar una opción en el Spinner",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            } else {
                Toast.makeText(
                    this,
                    "Debes indicar los 2 operandos.",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }
}