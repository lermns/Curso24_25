package com.example.demo_3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo_3.adapters.UserAdapter
import com.example.demo_3.data.dao.UserDAOImpl
import com.example.demo_3.databinding.ActivityMainBinding
import com.example.demo_3.model.User
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
            val name = binding.editTextTextName.text.toString()
            val email = binding.editTextTextEmail.text.toString()
            if (name.isNotEmpty() && email.isNotEmpty()) {
                val user = User(
                    name = binding.editTextTextName.text.toString(),
                    email = binding.editTextTextEmail.text.toString()
                )
                operaciones.insertarUser(user)
                resetearEditText()
            }else {
                Snackbar.make(binding.root, "Campos vacios...! ", Snackbar.LENGTH_LONG).show()
            }
        }

        binding.buttonAct.setOnClickListener {
            val name = binding.editTextTextName.text.toString()
            val email = binding.editTextTextEmail.text.toString()
            if (binding.editTextTextID.text.isNotEmpty()) {
                if (name.isNotEmpty() || email.isNotEmpty()) {
                        val user = User(
                            binding.editTextTextID.text.toString().toInt(),
                            binding.editTextTextName.text.toString(),
                            binding.editTextTextEmail.text.toString()
                        )
                        operaciones.actualizarUser(user)
                        resetearEditText()
                }else
                    Snackbar.make(binding.root, "Campos vacíos, nada que actualizar...!", Snackbar.LENGTH_LONG).show()

            }else
                Snackbar.make(binding.root, "ID vacío...! ", Snackbar.LENGTH_LONG).show()
        }

        binding.buttonDelete.setOnClickListener {
            if (binding.editTextTextID.text.isNotEmpty()) {
                val campoId = binding.editTextTextID.text.toString().toInt()
                if (campoId!=0){
                    operaciones.borrarUser(campoId)
                    resetearEditText()
                }else
                    Snackbar.make(binding.root, "ID no válido...!", Snackbar.LENGTH_LONG).show()
            }else {
                Snackbar.make(binding.root, "ID vacío... Se borraron todos los usuarios", Snackbar.LENGTH_LONG).show()
                operaciones.borrarTodoUsers()
            }
        }

        binding.buttonConsultar.setOnClickListener {
            val campoId = binding.editTextTextID.text.toString()
            if(campoId.isEmpty()){
                resetearEditText()
                mostrarUsuarios()
            }else {
                val existe = operaciones.leerUsers().stream().filter { it.id == campoId.toInt() }.count()
                if (existe > 0) {
                    val user = leerUsersPerID(campoId.toInt())
                    binding.editTextTextName.setText(user.name)
                    binding.editTextTextEmail.setText(user.email)
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
        binding.editTextTextID.setText("")
        binding.editTextTextName.setText("")
        binding.editTextTextEmail.setText("")
    }
}