package com.example.pmdm_ramosl_1aeval

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivitySegunda : AppCompatActivity() {
    private lateinit var textViewEquipoA: TextView
    private lateinit var textViewEquipoB: TextView
    private lateinit var textViewContA: TextView
    private lateinit var textViewContB: TextView
    private lateinit var buttonPunt3A: AppCompatButton
    private lateinit var buttonPunt2A: AppCompatButton
    private lateinit var buttonPunt1A: AppCompatButton
    private lateinit var buttonPunt3B: AppCompatButton
    private lateinit var buttonPunt2B: AppCompatButton
    private lateinit var buttonPunt1B: AppCompatButton
    private lateinit var buttonReiniciar: AppCompatButton
    private lateinit var buttonCambioCampo: AppCompatButton
    private lateinit var buttonDeshacer: AppCompatButton
    private var contALand =""
    private var contBLand =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_segunda)

        val toolbar = findViewById<Toolbar>(R.id.toolbarContador)
        setSupportActionBar(toolbar)
        toolbar.title = "Marcador Baloncesto"

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        var lastChange = ""
        textViewEquipoA = findViewById(R.id.textViewTeamA)
        textViewEquipoB = findViewById(R.id.textViewTeamB)
        buttonPunt1A = findViewById(R.id.buttonSumar1A)
        buttonPunt2A = findViewById(R.id.buttonSumar2A)
        buttonPunt3A = findViewById(R.id.buttonSumar3A)
        buttonPunt1B = findViewById(R.id.buttonSumar1B)
        buttonPunt2B = findViewById(R.id.buttonSumar2B)
        buttonPunt3B = findViewById(R.id.buttonSumar3B)
        textViewContA = findViewById(R.id.textViewPuntosA)
        textViewContB = findViewById(R.id.textViewPuntosB)
        buttonCambioCampo = findViewById(R.id.buttonCambioCampo)
        buttonReiniciar = findViewById(R.id.buttonResetear)
        buttonDeshacer = findViewById(R.id.buttonDeshacer)

        val equipoA = intent.getStringExtra("EQUIPOA")
        val equipoB = intent.getStringExtra("EQUIPOB")

        textViewEquipoA.text = equipoA
        textViewEquipoB.text = equipoB

        buttonPunt1A.setOnClickListener{
            var cont = Integer.parseInt( textViewContA.text.toString())
            cont++
            textViewContA.text = (cont).toString()
            lastChange = ""
            lastChange = "1A"
            contALand = textViewContA.text.toString()
        }
        buttonPunt2A.setOnClickListener{
            var cont = Integer.parseInt( textViewContA.text.toString())
            cont+=2
            textViewContA.text = (cont).toString()
            lastChange = ""
            lastChange = "2A"
            contALand = textViewContA.text.toString()
        }
        buttonPunt3A.setOnClickListener{
            var cont = Integer.parseInt( textViewContA.text.toString())
            cont+=3
            textViewContA.text = (cont).toString()
            lastChange = ""
            lastChange = "3A"
            contALand = textViewContA.text.toString()
        }

        buttonPunt1B.setOnClickListener{
            var cont = Integer.parseInt( textViewContB.text.toString())
            cont++
            textViewContB.text = (cont).toString()
            lastChange = ""
            lastChange = "1B"
            contBLand = textViewContB.text.toString()
        }
        buttonPunt2B.setOnClickListener{
            var cont = Integer.parseInt( textViewContB.text.toString())
            cont+=2
            textViewContB.text = (cont).toString()
            lastChange = ""
            lastChange = "2B"
            contBLand = textViewContB.text.toString()
        }
        buttonPunt3B.setOnClickListener{
            var cont = Integer.parseInt( textViewContB.text.toString())
            cont+=3
            textViewContB.text = (cont).toString()
            lastChange = ""
            lastChange = "3B"
            contBLand = textViewContB.text.toString()
        }

        buttonReiniciar.setOnClickListener{
            textViewContA.text = "0"
            textViewContB.text = "0"
            Log.d(TAG, "Se ha reiniciado los marcadores")
            contBLand = textViewContB.text.toString()
            contALand = textViewContA.text.toString()
        }

        buttonCambioCampo.setOnClickListener{
            val contA = Integer.parseInt( textViewContA.text.toString())
            val contB = Integer.parseInt( textViewContB.text.toString())

            textViewContA.text = (contB).toString()
            textViewContB.text = (contA).toString()

            val name = textViewEquipoA.text
            textViewEquipoA.text = textViewEquipoB.text
            textViewEquipoB.text = name
        }

        buttonDeshacer.setOnClickListener {
            when(lastChange){
                "1A" -> {
                    var contA = Integer.parseInt( textViewContA.text.toString())
                    contA--
                    textViewContA.text = (contA).toString()
                }
                "2A" -> {
                    var contA = Integer.parseInt( textViewContA.text.toString())
                    contA -= 2
                    textViewContA.text = (contA).toString()
                }
                "3A" -> {
                    var contA = Integer.parseInt( textViewContA.text.toString())
                    contA -= 3
                    textViewContA.text = (contA).toString()
                }
                "1B" -> {
                    var contB = Integer.parseInt( textViewContB.text.toString())
                    contB--
                    textViewContB.text = (contB).toString()
                }
                "2B" -> {
                    var contB = Integer.parseInt( textViewContB.text.toString())
                    contB-=2
                    textViewContB.text = (contB).toString()
                }
                "3B" -> {
                    var contB = Integer.parseInt(textViewContB.text.toString())
                    contB -= 3
                    textViewContB.text = (contB).toString()
                }
                "" -> {
                    Toast.makeText(this, "No hay puntos", Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    override fun onSaveInstanceState(estadoAGuardar: Bundle) {
        super.onSaveInstanceState(estadoAGuardar)
        estadoAGuardar.putString("valorA", contALand)
        estadoAGuardar.putString("valorB", contBLand)
    }

    override fun onRestoreInstanceState(estadoARestaurar: Bundle) {
        super.onRestoreInstanceState(estadoARestaurar)
        contALand= estadoARestaurar.getString("valorA").toString()
        contBLand= estadoARestaurar.getString("valorB").toString()

        val textViewA=findViewById<TextView>(R.id.textViewPuntosA)
        val textViewB=findViewById<TextView>(R.id.textViewPuntosB)
        textViewA.text = contALand
        textViewB.text = contBLand
    }

}