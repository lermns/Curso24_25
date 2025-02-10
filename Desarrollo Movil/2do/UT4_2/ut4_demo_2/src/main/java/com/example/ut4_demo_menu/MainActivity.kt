package com.example.ut4_demo_menu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ut4_demo_menu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(binding.toolbar.id))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    //  Sobreescribimos el metodo para gestionar las pulsaciones
    /*
    * Este metodo nos permite especificar que accion queremos realizar cuando el usuario pincha
    * en las diferentes opciones del menu.
    */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_buscar -> {
                Log.i("MENÚ", "Pulsando opcion buscar.")
                return true
            }
            R.id.action_nuevo -> {
                Toast.makeText(this, "Pulsada opción Nuevo", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_activity2 -> {
                startActivity(Intent(this, MainActivity2::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}