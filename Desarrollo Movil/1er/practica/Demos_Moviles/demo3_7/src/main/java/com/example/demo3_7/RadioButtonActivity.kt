package com.example.demo3_7

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar

class RadioButtonActivity : AppCompatActivity() {
    private lateinit var btnCalcular: AppCompatButton
    private lateinit var etNum1: EditText
    private lateinit var etNum2: EditText
    private lateinit var tvResultado: TextView
    private lateinit var rbSumar: RadioButton
    private lateinit var rbRestar: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio_button)
        val toolbar = findViewById<Toolbar>(R.id.rbToolbar)
        setSupportActionBar(toolbar)

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        btnCalcular = findViewById(R.id.buttonCalcularRadio)
        etNum1 = findViewById(R.id.editTextRadio1)
        etNum2 = findViewById(R.id.editTextRadio2)
        tvResultado = findViewById(R.id.textViewRadio)
        rbSumar = findViewById(R.id.radioButton1)
        rbRestar = findViewById(R.id.radioButton2)

        btnCalcular.setOnClickListener {
            val num1String = etNum1.text.toString()
            val num2String = etNum2.text.toString()
            var resultado="Resultado:\n"

            val num1 = etNum1.text.toString().toDoubleOrNull() ?: 0.0
            val num2 = etNum2.text.toString().toDoubleOrNull() ?: 0.0

            if (num1String.trim().isNotEmpty() && num2String.trim().isNotEmpty()) {//   empieza aqui
                if (rbSumar.isChecked) {
                    resultado += "Suma = ${num1 + num2}\n"
                }
                else if (rbRestar.isChecked) {
                    resultado += "Resta = ${num1 - num2}"
                }/*
                else {//    este usaria el toast que es otra manera de hacerlo
                    Toast.makeText(this, "Debes seleccionar una operación.", Toast.LENGTH_SHORT).show()
                }*/
            } else {// otra manera de dar un aviso de que los campos estan vacios
                if (num1String.trim().isEmpty()) {
                    etNum1.error = "Campo obligatorio"
                }
                if (num2String.trim().isEmpty()) {
                    etNum2.error = "Campo obligatorio"
                }
            }
            tvResultado.text = resultado
        }
    }
}