package com.example.ramosl_pmdm_examen_2aeval.dao

import MascotaDAO
import android.content.ContentValues
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.view.View
import com.example.ramosl_pmdm_examen_2aeval.UserSQLiteHelper
import com.example.ramosl_pmdm_examen_2aeval.model.Mascota
import com.google.android.material.snackbar.Snackbar

class MascotaDAOImpl(private val view: View, private val dbHelper: SQLiteOpenHelper):MascotaDAO {

    override fun insertarMascota(user: Mascota) {
        val db = dbHelper.writableDatabase

        val newMascota = ContentValues().apply {
            put(UserSQLiteHelper.COLUMN_NAME, user.nombre)
            put(UserSQLiteHelper.COLUMN_TIPO, user.tipo)
            put(UserSQLiteHelper.COLUMN_SEXO, user.sexo)
        }

        val idInsertado = db.insert(UserSQLiteHelper.TABLE_NAME, null, newMascota)

        Snackbar.make(view, "Mascota insertado con id $idInsertado", Snackbar.LENGTH_LONG).show()
    }

    override fun leerMascota(): List<Mascota> {
        val listaMascotas = mutableListOf<Mascota>()

        //  abrimos base de datos para solo lectura
        val  db = dbHelper.readableDatabase

        //  ejecutamos la consulta
        val cursor = db.rawQuery("select * from ${UserSQLiteHelper.TABLE_NAME}", null)


        cursor.use {
            while (it.moveToNext()){
                val id = it.getInt(0)
                val name = it.getString(1)
                val tipo = it.getString(2)
                val sexo = it.getString(3)
                //  añadimos una mascota a nuestra lista
                listaMascotas.add(Mascota(id, name, tipo, sexo))
            }
        }

        return listaMascotas
    }


    override fun borrarMascota(id: Int) {
        val db = dbHelper.writableDatabase

        if(!comprobarId(id)){
            Log.w("MiApp", "El id $id no existe")
            Snackbar.make(view, "El id $id no existe", Snackbar.LENGTH_LONG).show()
            return
        }

        val clausulaWhere = "${UserSQLiteHelper.COLUMN_ID} = ?"
        val whereArgs = arrayOf(id.toString())
        val filasBorradas = db.delete(
            UserSQLiteHelper.TABLE_NAME, // Nombre de la tabla
            clausulaWhere, //   clausula where
            whereArgs //    argumentos de la clausula where
        )

        if(filasBorradas==0){
            Log.e("MiApp", "Error inesperado en borrar")
        }else{
            Log.w("MiApp", "Mascota $id borrado")
            Snackbar.make(view, "Mascota $id borrado", Snackbar.LENGTH_LONG).show()
        }
    }

    override fun borrarTodoMascota(){
        val db = dbHelper.writableDatabase
        val filasBorradas = db.delete(UserSQLiteHelper.TABLE_NAME, null, null)
        if(filasBorradas==0){
            Snackbar.make(view, "No se han borrado Mascotas", Snackbar.LENGTH_LONG).show()
        }else{
            Snackbar.make(view, "$filasBorradas Mascota borrado", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun comprobarId(id :Int?): Boolean{
        val db = dbHelper.readableDatabase
        val sql = "select * from ${UserSQLiteHelper.TABLE_NAME} where ${UserSQLiteHelper.COLUMN_ID} = ?"

        val cursor = db.rawQuery(sql, arrayOf(id.toString()))

        val existe = cursor.count > 0
        cursor.close()

        return existe
    }

}














