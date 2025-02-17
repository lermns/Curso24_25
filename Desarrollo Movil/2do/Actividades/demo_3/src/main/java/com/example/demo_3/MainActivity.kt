package com.example.demo_3

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo_3.adapters.UserAdapter
import com.example.demo_3.data.dao.UserDAOImpl
import com.example.demo_3.databinding.ActivityMainBinding
import com.example.demo_3.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var operaciones: UserDAOImpl
    private val dbHelper = UserSQLiteHelper(this)

    private lateinit var listaUsers: List<User>
    private lateinit var adapter: UserAdapter
    private val manager = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operaciones = UserDAOImpl(binding.root, dbHelper)
        binding.editTextTextID.setText("0")
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
            Log.d("PRUEBA PRUEBA", "$campoId")
            if (campoId!=0){
                operaciones.borrarUser(campoId)
                resetearEditText()
            }


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
                }
            }
        }
        binding.buttonLimpiar.setOnClickListener{
            mostrarUsuarios()
        }
    }

    private fun leerUsersPerID(id : Int): User{
        return operaciones.leerUsers().first{it.id==id}
    }

    //  adaptado a Recycler View
    private fun mostrarUsuarios(){
        val listUser = operaciones.leerUsers()
        if(listUser.isEmpty()){
            //  TODO: mostrar textView lista vacia
        }else {
            binding.recyclerView.layoutManager = manager
            adapter = UserAdapter(listUser)
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