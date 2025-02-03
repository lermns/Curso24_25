package com.example.demo_2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserSQLiteHelper (context: Context):
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "user.db"
        val TABLE_NAME = "user"
        val COLUMN_ID = "id"
        val COLUMN_NAME = "name"
        val COLUMN_EMAIL = "email"
    }

    private val sqlCreateTable = "create table if not exists $TABLE_NAME(" +
                                 "$COLUMN_ID integer primary key autoincrement," +
                                 "$COLUMN_NAME text," +
                                 "$COLUMN_EMAIL text)"

    private val sqlDropTable = "drop table $TABLE_NAME;"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(sqlCreateTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(sqlDropTable)
        db?.execSQL(sqlCreateTable)
    }
}