package com.example.ut4_demo_menu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_buscar -> {
                Log.i("menu", "Icono buscar pulsado.")
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