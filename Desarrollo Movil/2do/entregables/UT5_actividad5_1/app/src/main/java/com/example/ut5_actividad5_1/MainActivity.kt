package com.example.ut5_actividad5_1

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ut5_actividad5_1.adapters.UserAdapter
import com.example.ut5_actividad5_1.dao.UserDAOImpl
import com.example.ut5_actividad5_1.databinding.ActivityMainBinding
import com.example.ut5_actividad5_1.model.User
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var operaciones: UserDAOImpl
    private val dbHelper = UserSQLiteHelper(this)
    private val manager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operaciones = UserDAOImpl(binding.root, dbHelper)

//        operaciones.insertarUser(User(name = "Pepe", email = "adwad@adwda.com"))
//        operaciones.insertarUser(User(name = "Ana", email = "ana@adwda.com"))
//        operaciones.insertarUser(User(name = "Leo", email = "leo@adwda.com"))
//
//        val user = User(name="LeBron", email="erradiquenMurcia@yahoo.com")
//        operaciones.insertarUser(user)

        binding.buttonInsertar.setOnClickListener {
            val name = binding.tilName.text.toString()
            val email = binding.tilEmail.text.toString()
            if (name.isNotEmpty() && email.isNotEmpty()) {
                val user = User(
                    name = binding.tilName.text.toString(),
                    email = binding.tilEmail.text.toString()
                )
                operaciones.insertarUser(user)
                resetearEditText()
            }else {
                Snackbar.make(binding.root, "Campos vacios...! ", Snackbar.LENGTH_LONG).show()
            }
        }

        binding.buttonAct.setOnClickListener {
            val name = binding.tilName.text.toString()
            val email = binding.tilEmail.text.toString()
            if (binding.tilEmail.text.toString().isNotEmpty()) {
                if (name.isNotEmpty() || email.isNotEmpty()) {
                    val user = User(
                        binding.tilID.text.toString().toInt(),
                        binding.tilName.text.toString(),
                        binding.tilEmail.text.toString()
                    )
                    operaciones.actualizarUser(user)
                    resetearEditText()
                }else
                    Snackbar.make(binding.root, "Campos vacíos, nada que actualizar...!", Snackbar.LENGTH_LONG).show()

            }else
                Snackbar.make(binding.root, "ID vacío...! ", Snackbar.LENGTH_LONG).show()
        }

        binding.buttonDelete.setOnClickListener {
            val idTexto = binding.tilID.text.toString()

            if (idTexto.isNotEmpty()) {
                val campoId = idTexto.toIntOrNull() // Evita NumberFormatException
                if (campoId != null && campoId > 0) {
                    try {
                        operaciones.borrarUser(campoId)
                        resetearEditText()
                    } catch (e: Exception) {
                        Log.e("MiApp", "Error al borrar usuario: ${e.message}")
                        Snackbar.make(binding.root, "Error al borrar usuario", Snackbar.LENGTH_LONG).show()
                    }
                } else {
                    Snackbar.make(binding.root, "ID no válido...!", Snackbar.LENGTH_LONG).show()
                }
            } else {
                Snackbar.make(binding.root, "ID vacío... Se borraron todos los usuarios", Snackbar.LENGTH_LONG).show()
                try {
                    operaciones.borrarTodoUsers()
                } catch (e: Exception) {
                    Log.e("MiApp", "Error al borrar todos los usuarios: ${e.message}")
                    Snackbar.make(binding.root, "Error al borrar usuarios", Snackbar.LENGTH_LONG).show()
                }
            }
        }

        binding.buttonConsultar.setOnClickListener {
            val campoId = binding.tilID.text.toString()
            if(campoId.isEmpty()){
                resetearEditText()
                mostrarUsuarios()
            }else {
                val existe = operaciones.leerUsers().stream().filter { it.id == campoId.toInt() }.count()
                if (existe > 0) {
                    val user = leerUsersPerID(campoId.toInt())
                    binding.tilName.setText(user.name)
                    binding.tilEmail.setText(user.email)
                }else
                    Snackbar.make(binding.root, "El usuario no existe en la base de datos.", Snackbar.LENGTH_LONG).show()
            }
        }

        binding.buttonLimpiar.setOnClickListener{
            operaciones.borrarTodoUsers()
        }
    }

    private fun leerUsersPerID(id : Int): User{
        return operaciones.leerUsers().first{it.id==id}
    }

    private fun mostrarUsuarios(){
        val listUser = operaciones.leerUsers()
        if(listUser.isEmpty()){
            binding.tvListaVacia.visibility = View.VISIBLE
            binding.recyclerView.visibility = View.GONE
        }else {
            binding.tvListaVacia.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE

            binding.recyclerView.layoutManager = manager
            binding.recyclerView.adapter = UserAdapter(listUser)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dbHelper.close()
    }

    private fun resetearEditText() {
        binding.tilID.setText("")
        binding.tilName.setText("")
        binding.tilEmail.setText("")
    }
}