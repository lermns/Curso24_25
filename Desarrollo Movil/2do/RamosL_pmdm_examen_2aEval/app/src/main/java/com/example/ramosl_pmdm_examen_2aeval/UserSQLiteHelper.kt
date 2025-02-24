package com.example.ramosl_pmdm_examen_2aeval

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserSQLiteHelper (context: Context):
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "user.dbMascotas"
        val TABLE_NAME = "mascotas"
        val COLUMN_ID = "id"
        val COLUMN_NAME = "nombre"
        val COLUMN_TIPO = "tipo"
        val COLUMN_SEXO = "sexo"
    }

    private val sqlCreateTable = "create table if not exists $TABLE_NAME(" +
                                 "$COLUMN_ID integer primary key autoincrement," +
                                 "$COLUMN_NAME text," +
                                 "$COLUMN_TIPO text," +
                                 "$COLUMN_SEXO text)"

    private val sqlDropTable = "drop table $TABLE_NAME;"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(sqlCreateTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(sqlDropTable)
        db?.execSQL(sqlCreateTable)
    }
}