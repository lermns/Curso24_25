package com.example.ramosl_pmdm_examen_2aeval

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ramosl_pmdm_examen_2aeval.dao.MascotaDAOImpl
import com.example.ramosl_pmdm_examen_2aeval.databinding.ActivityMainBinding
import com.example.ramosl_pmdm_examen_2aeval.model.Mascota
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var operaciones: MascotaDAOImpl
    private val dbHelper = UserSQLiteHelper(this)
    private val manager = LinearLayoutManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtenemos una referencia a la Toolbar y la asignamos a la Activity
        val toolbar = findViewById<Toolbar>(R.id.toolbar1)
        setSupportActionBar(toolbar)
        // Cambiamos el título
        toolbar.title = "BDD Mascotas"


        operaciones = MascotaDAOImpl(binding.root, dbHelper)

        // por alguna razon dice que lo inserta pero al mostrarlo salen cosas raras
        binding.btnInsertar.setOnClickListener {
            val name = binding.nombreMascota.toString()
            val tipo = binding.tipoMascota.toString()
            val sexo = binding.spinnerMascota.selectedItem.toString()
            if (name.isNotEmpty() && tipo.isNotEmpty() && sexo.isNotEmpty()) {
                val mascota = Mascota(
                    nombre = binding.nombreMascota.toString(),
                    tipo = binding.tipoMascota.toString(),
                    sexo = binding.spinnerMascota.selectedItem.toString()
                )
                operaciones.insertarMascota(mascota)
            }else {
                Snackbar.make(binding.root, "Campos vacios...! ", Snackbar.LENGTH_LONG).show()
            }
        }

        // es en este apartado donde la cosa no sale bien
        binding.btnConsTodos.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            val lista = operaciones.leerMascota()
            val table=StringBuilder()
            if (lista.isNotEmpty()) {
                operaciones.leerMascota().forEach{table.append("$it\n")}
            }
            intent.putExtra("MENSAJE", table.toString())
            startActivity(intent)
        }

        // por alguna razon simpre me dice que no existe la mascota
        binding.btnConsNombre.setOnClickListener {
            val campoNom = binding.nombreMascota.text.toString()
            if(campoNom.isEmpty()){
                resetearEditText()
            }else {
                // esta fduncion verifica si almenos existe 1 mascota y la devuelve
                val existe = operaciones.leerMascota().stream().filter { it.nombre == campoNom}.count()
                if (existe > 0) {
                    val intent = Intent(this, MainActivity2::class.java)
                    val mascota = leerMascPerName(campoNom)
                    intent.putExtra("Mensaje2", mascota.toString())
                    startActivity(intent)
                }else
                    Snackbar.make(binding.root, "Mascota no encontrada", Snackbar.LENGTH_LONG).show()
            }
        }

        //  en caso de encontrar el id este lo borra
        binding.btnBorrarPorID.setOnClickListener {
            if (binding.idMascota.text.isNotEmpty()) {
                val campoId = binding.idMascota.text.toString().toInt()
                if (campoId!=0){
                    operaciones.borrarMascota(campoId)
                    resetearEditText()
                }else
                    Snackbar.make(binding.root, "ID no válido...!", Snackbar.LENGTH_LONG).show()
            }else {
                Snackbar.make(binding.root, "ID vacío... ", Snackbar.LENGTH_LONG).show()
            }
        }

    }
    //  esta es la funcion
    private fun leerMascPerName(name : String): Mascota {
        return operaciones.leerMascota().first{it.nombre==name}
    }

    private fun resetearEditText() {
        binding.idMascota.setText("")
        binding.nombreMascota.setText("")
        binding.tipoMascota.setText("")
    }
}