package com.example.demo3_7

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar

class CheckBoxActivity : AppCompatActivity() {
    private lateinit var btnCalcular: AppCompatButton
    private lateinit var edtext1 : EditText
    private lateinit var edtext2 : EditText
    private lateinit var txtViewRes : TextView
    private lateinit var chcbxSumar: CheckBox
    private lateinit var chcbxRestar: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_check_box)
        val toolbar = findViewById<Toolbar>(R.id.cbToolbar)
        setSupportActionBar(toolbar)

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        btnCalcular = findViewById(R.id.buttonCalcular)
        txtViewRes = findViewById(R.id.textRespCheckBox)
        edtext1 = findViewById(R.id.editText1)
        edtext2 = findViewById(R.id.editText2)
        chcbxSumar = findViewById(R.id.checkBoxSum)
        chcbxRestar = findViewById(R.id.checkBoxRest)

        btnCalcular.setOnClickListener {
            var resultado="";

            val num1 = edtext1.text.toString().toDoubleOrNull() ?: 0.0
            val num2 = edtext2.text.toString().toDoubleOrNull() ?: 0.0

            if (chcbxSumar.isChecked)
                resultado += "Suma = ${num1 + num2}\n"

            if (chcbxRestar.isChecked)
                resultado += "Resta = ${num1 - num2}"

            txtViewRes.text = resultado
        }
    }
}