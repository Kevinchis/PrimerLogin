package com.example.loginbicho1
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import androidx.core.content.contentValuesOf


val DATABASE_NAME="Registro"
    val TABLE_NAME="User"
    val COL_LOGIN="Login"
    val COL_CONTRA="Contraseña"
    val COL_ID="id"

    class DataBaseHandler(var context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null,1) {
        override fun onCreate(db: SQLiteDatabase?) {
            val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_LOGIN + " VARCHAR (256), " +
                    COL_CONTRA + " VARCHAR (256))";

            db?.execSQL(createTable)
        }

        override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
            TODO("Not yet implemented")
        }

        fun insertData(user: User) {
            val db = this.writableDatabase
            var cv = contentValuesOf()
            cv.put(COL_LOGIN, user.login)
            cv.put(COL_CONTRA, user.contraseña)
            var result = db.insert(TABLE_NAME, null, cv)
            if (result == 1.toLong())
                Toast.makeText(context, "Fallo", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
        }

    }