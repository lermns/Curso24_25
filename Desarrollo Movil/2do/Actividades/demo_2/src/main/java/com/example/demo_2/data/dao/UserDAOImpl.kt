package com.example.demo_2.data.dao

import android.content.ContentValues
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.view.View
import com.example.demo_2.UserSQLiteHelper
import com.example.demo_2.model.User
import com.google.android.material.snackbar.Snackbar

class UserDAOImpl(private val view: View, private val dbHelper: SQLiteOpenHelper):UserDAO {

    override fun insertarUser(user: User) {
        val db = dbHelper.writableDatabase
        //  opción A execSQL
//        db.execSQL("insert into user (name, email) values('${user.name}', '${user.email}')")
//        db.execSQL("insert into ${UserSQLiteHelper.TABLE_NAME} (${UserSQLiteHelper.COLUMN_NAME}, ${UserSQLiteHelper.COLUMN_EMAIL}) values('${user.name}', '${user.email}')")

        //  opción B Metodo insert
        val newUser = ContentValues().apply {
            put(UserSQLiteHelper.COLUMN_NAME, user.name)
            put(UserSQLiteHelper.COLUMN_EMAIL, user.email)
        }// Metodo aply() para aplicar todos los cambios necesarios

        val idInsertado = db.insert(UserSQLiteHelper.TABLE_NAME, null, newUser)

        Snackbar.make(view, "Usuario insertado con id $idInsertado", Snackbar.LENGTH_LONG).show()
    }

    /*override fun leerUsero(id: Int): User {
        TODO("Not yet implemented")
    }*/

    override fun leerUsers(): List<User> {
        val listaUsers = mutableListOf<User>()

        //  abrimos base de datos para solo lectura
        val  db = dbHelper.readableDatabase

        //  ejecutamos la consulta
        val cursor = db.rawQuery("select * from ${UserSQLiteHelper.TABLE_NAME}", null)

        //  opcion A recorremos el cursor
//        while (cursor.moveToNext()){
//            val id = cursor.getInt(0)
//            val name = cursor.getString(1)
//            val email = cursor.getString(2)
//            //  añadimos un usuario a nuestra lista de usuarios
//            listaUsers.add(User(id, name, email))
//        }
//        cursor.close()

        //  Opcion B con user
        cursor.use {
            while (it.moveToNext()){
                val id = it.getInt(0)
                val name = it.getString(1)
                val email = it.getString(2)
                //  añadimos un usuario a nuestra lista de usuarios
                listaUsers.add(User(id, name, email))
            }
        }

        return listaUsers
    }

    override fun actualizarUser(user: User) {
        val db = dbHelper.writableDatabase

        if(!comprobarId(user.id)){
            Log.w("MiApp", "El id ${user.id} no existe")
            Snackbar.make(view, "El id ${user.id} no existe", Snackbar.LENGTH_LONG).show()
            return
        }
        val userAcutalizado = ContentValues().apply {
            put(UserSQLiteHelper.COLUMN_NAME, user.name)
            put(UserSQLiteHelper.COLUMN_EMAIL, user.email)
        }

        val clausulaWhere = "${UserSQLiteHelper.COLUMN_ID} = ?"
        val whereArgs = arrayOf(user.id.toString())
        val filasActualizadas = db.update(
            UserSQLiteHelper.TABLE_NAME, // Nombre de la tabla
            userAcutalizado, // usuario actualizado
            clausulaWhere, //   clausula where
            whereArgs //    argumentos de la clausula where
             )

        if(filasActualizadas==0){
            Log.e("MiApp", "Error inesperado en actualizar")
        }else{
            Log.w("MiApp", "Usuario ${user.id} actualizado")
            Snackbar.make(view, "Usuario ${user.id} actualizado", Snackbar.LENGTH_LONG).show()
        }
    }

    override fun borrarUser(id: Int) {
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
            Log.w("MiApp", "Usuario $id borrado")
            Snackbar.make(view, "Usuario $id borrado", Snackbar.LENGTH_LONG).show()
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














