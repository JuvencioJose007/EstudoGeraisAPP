package com.estudos

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var preferencias: SharedPreferences? = null
    var editPreferencias: SharedPreferences.Editor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferencias = getSharedPreferences("Estudos", Context.MODE_PRIVATE)
        editPreferencias = preferencias?.edit()

        if (preferencias!!.getBoolean("autenticado", false)) {
            val activitThow = Intent(this, activity_main_two::class.java)
            activitThow.putExtra("email", preferencias?.getString("email", ""))
            startActivity(activitThow)
        }

        btnLogin.setOnClickListener {
            autenticator()
        }
    }

    fun autenticator() {
        val email = etLogin.text.toString()
        val senha = etPassword.text.toString()

        if (email == "raissa" && senha == "juvencio") {
            val activitThow = Intent(this, activity_main_two::class.java)
            activitThow.putExtra("email", email)
            editPreferencias?.putString("email", email)
            editPreferencias?.putBoolean("autenticado", true)
            editPreferencias?.commit()

            startActivity(activitThow)
        } else {
            Toast.makeText(this, "Email ou senha inválido!", Toast.LENGTH_SHORT).show()
        }
    }


}
