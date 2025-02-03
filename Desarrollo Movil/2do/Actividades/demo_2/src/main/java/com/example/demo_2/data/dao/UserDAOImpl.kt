package com.example.demo_2.data.dao

import android.content.ContentValues
import android.database.sqlite.SQLiteOpenHelper
import android.view.View
import com.example.demo_2.UserSQLiteHelper
import com.example.demo_2.model.User
import com.google.android.material.snackbar.Snackbar

class UserDAOImpl(private val view: View, private val dbHelper: SQLiteOpenHelper):UserDAO {

    override fun insertarUser(user: User) {
        val db = dbHelper.writableDatabase
        //  opción A execSQL
        db.execSQL("insert into user (name, email) values('${user.name}', '${user.email}')")
        db.execSQL("insert into ${UserSQLiteHelper.TABLE_NAME} (${UserSQLiteHelper.COLUMN_NAME}, ${UserSQLiteHelper.COLUMN_EMAIL}) values('${user.name}', '${user.email}')")

        //  opción B Metodo insert
        val newUser = ContentValues().apply {
            put(UserSQLiteHelper.COLUMN_NAME, user.name)
            put(UserSQLiteHelper.COLUMN_EMAIL, user.email)
        }// Metodo aply() para aplicar todos los cambios necesarios

        val idInsertado = db.insert(UserSQLiteHelper.TABLE_NAME, null, newUser)

        Snackbar.make(view, "Usuario insertado con id $idInsertado", Snackbar.LENGTH_LONG).show()
    }

    override fun leerUsero(id: Int): User {
        TODO("Not yet implemented")
    }

    override fun leerUsers(): List<User> {
        TODO("Not yet implemented")
    }

    override fun actualizarUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun borrarUser(id: Int) {
        TODO("Not yet implemented")
    }

}














