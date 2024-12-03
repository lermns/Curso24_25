package com.example.demo3_8

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private var cont=0
    private lateinit var textViewContador: TextView
    private lateinit var btnAdd: AppCompatButton
    private lateinit var btnRestar: AppCompatButton
    private lateinit var btnNewActivity: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "En el método onCreate")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbarMain)
        setSupportActionBar(toolbar)
        toolbar.title = "MainActivity"


        textViewContador=findViewById(R.id.textViewContador)
        textViewContador.text = cont.toString()
        btnAdd=findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener {
            cont++
            textViewContador.text = cont.toString()
        }

        btnRestar = findViewById(R.id.btnRestar)
        btnRestar.setOnClickListener {
            cont--
            textViewContador.text = cont.toString()
        }

        btnNewActivity = findViewById(R.id.btnNewActivity)
        btnNewActivity.setOnClickListener {
            val intent = Intent(this, MostrarContadorActivity::class.java)
            intent.putExtra("CONTADOR", cont)
            startActivity(intent)
        }


    }

    override fun onSaveInstanceState(estadoAGuardar: Bundle) {
        super.onSaveInstanceState(estadoAGuardar)
        //Log.d(TAG, "onSaveInstanceState. Guardo contador con valor = $cont")
        estadoAGuardar.putInt("CONTADOR", cont)
    }

    override fun onRestoreInstanceState(estadoARestaurar: Bundle) {
        super.onRestoreInstanceState(estadoARestaurar)
        cont=estadoARestaurar.getInt("CONTADOR")
        //Log.d(TAG, "onRestoreInstanceState. Restauro al contador el valor = $cont")
        val textViewContador=findViewById<TextView>(R.id.textViewContador)
        textViewContador.text = cont.toString()
    }
    /*
        override fun onStart() {
            super.onStart()
            Log.d(TAG, "En el método onStart")
        }

        override fun onResume() {
            super.onResume()
            Log.d(TAG, "En el método onResume")
        }

        override fun onPause() {
            super.onPause()
            Log.d(TAG, "En el método onPause")
        }

        override fun onStop() {
            super.onStop()
            Log.d(TAG, "En el método onStop")
        }

        override fun onRestart() {
            super.onRestart()
            Log.d(TAG, "En el método onRestart")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.d(TAG, "En el método onDestroy")
        }
    */
}