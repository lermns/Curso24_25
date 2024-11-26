package com.example.demo3_7

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class CheckBox : AppCompatActivity() {
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
    }

    //metodo para controlar los clicks en el programa
    fun onBtnCalcularClicked(view: View){
        var resultado="";

        if(chcbxSumar.isChecked)
            resultado = "Suma = ${edtext1.toString().toDouble() + edtext2.toString().toDouble()}"

        if(chcbxRestar.isChecked)
            resultado = "\nResta = ${edtext1.toString().toDouble() - edtext2.toString().toDouble()}"

        txtViewRes.text = resultado
    }
}