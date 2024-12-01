package com.example.demo3_4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var txtMessage : EditText
    private lateinit var btnEnviar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // obtiene la referencia del EditText y del Boton para usarlos dentro del activity
        txtMessage = findViewById(R.id.txtMessage)
        btnEnviar = findViewById(R.id.botonEnviar)

        // usamos una expresion lambda con el metodo listener para en caso este boton sea presionado
        // se ejecute el contenido
        btnEnviar.setOnClickListener {
            //  ejecutamos un Intent que entre varias cosas, en este caso intenta abrir una nueva actividad
            //  le pasamos el contexto actual que es donde estamos y le pasamos el activity como 2do
            //  parametro para que lo intente abrir, le especificamos que es un objeto pasandole class
            //  y como android reconoce java le pasamos el .java ya que si no este no entenderia que es
            //  un kclass (kotlin class) que es lo que devuelve ::class
            val intent = Intent(this, SegundaActivity::class.java)
            //  Le pasa al contexto un String que tiene el txtMessage con el nombre de la variable que lo
            //  guardara que es MENSAJE para que en el otro activity puedan referenciarlo y usarlo
            intent.putExtra("MENSAJE", txtMessage.text.toString())
            //iniciamos el intent para cambiar de ventana
            startActivity(intent)
        }
    }
}