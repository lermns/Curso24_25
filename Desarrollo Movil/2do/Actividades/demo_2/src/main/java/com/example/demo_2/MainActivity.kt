package com.example.demo_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demo_2.data.dao.UserDAOImpl
import com.example.demo_2.databinding.ActivityMainBinding
import com.example.demo_2.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var operaciones: UserDAOImpl
    private val dbHelper = UserSQLiteHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operaciones = UserDAOImpl(binding.root, dbHelper)
        //mostrarUsuarios().forEach{ _ -> println()}
//        operaciones.insertarUser(User(name = "Pepe", email = "adwad@adwda.com"))
//        operaciones.insertarUser(User(name = "Ana", email = "ana@adwda.com"))
//        operaciones.insertarUser(User(name = "Leo", email = "leo@adwda.com"))
//
//        val user = User(name="LeBron", email="erradiquenMurcia@yahoo.com")
//        operaciones.insertarUser(user)

        //mostrarUsuarios().forEach{ _ -> println()}
        binding.buttonInsertar.setOnClickListener {
            //  Resetear edit text
        //resetearEditText()
            val user = User(
                name = binding.editTextTextName.text.toString(),
                email = binding.editTextTextEmail.text.toString()
            )
            operaciones.insertarUser(user)
            resetearEditText()
        }

        binding.buttonAct.setOnClickListener {
            //  Resetear edit text
            //resetearEditText()
            val user = User(
                binding.editTextTextID.text.toString().toInt(),
                binding.editTextTextName.text.toString(),
                binding.editTextTextEmail.text.toString()
            )
            operaciones.actualizarUser(user)
            resetearEditText()
        }

        binding.buttonDelete.setOnClickListener {
            val campoId = binding.editTextTextID.text.toString().toInt()
            operaciones.borrarUser(campoId)
            resetearEditText()
        }

        binding.buttonConsultar.setOnClickListener {
            val campoId = binding.editTextTextID.text.toString()
            if(campoId.isEmpty()){
                resetearEditText()
            }else {
                val existe = operaciones.leerUsers().stream().filter { it.id == campoId.toInt() }.count()
                if (existe > 0) {
                    val user = leerUsersPerID(campoId.toInt())
                    binding.editTextTextName.setText(user.name)
                    binding.editTextTextEmail.setText(user.email)
                }else
                    binding.editTextText6.text = "No existe el user..!"
            }
        }
        binding.buttonLimpiar.setOnClickListener{
            mostrarUsuarios()
        }
    }

    private fun leerUsersPerID(id : Int): User {
        return operaciones.leerUsers().first{it.id==id}
    }

    private fun mostrarUsuarios(){
        val listUser =operaciones.leerUsers()
        if(listUser.isEmpty()){
            binding.editTextText6.text = "No hay usuarios...!"
            return
        }
        val table = StringBuilder("id\t\t\t\tname\t\t\t\t\t\temail\n")

        operaciones.leerUsers().forEach{table.append("$it\n")}
        binding.editTextText6.text = table.toString()

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