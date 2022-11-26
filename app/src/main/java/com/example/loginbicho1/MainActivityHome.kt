package com.example.loginbicho1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivityHome : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainhome)
        val ed_login = findViewById<EditText>(R.id.ed_login)
        val ed_pass = findViewById<EditText>(R.id.ed_pass)
        val btn_ingresar = findViewById<Button>(R.id.btn_Ingresar)
        val btn_registro = findViewById<Button>(R.id.btn_registro)
        val context = this
        val db = DataBaseHandler(context)
        btn_registro.setOnClickListener {
            if (ed_login.text.toString().length > 0 &&
                ed_pass.text.toString().length > 0
            ) {
                var user = User(ed_login.text.toString(), ed_pass.text.toString())
                var db = DataBaseHandler(context)
                db.insertData(user)
            } else {
                Toast.makeText(context, "Registre los datos porfavor", Toast.LENGTH_SHORT).show();
            }
        
        }
    btn_ingresar.setOnClickListener{
        val intentIS = Intent(this, MainActivitySiguiente::class.java);
        val nombre = ed_login.text.toString()
        val datoN = Bundle()
        datoN.putString("NombreK", nombre)
        intentIS.putExtras(datoN)
        startActivity(intentIS);

    }
    }
}