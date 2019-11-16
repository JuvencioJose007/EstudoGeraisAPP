package com.estudos

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Toast
import com.estudos.model.JsonPlaceHolder
import com.estudos.request.LerRetorno
import kotlinx.android.synthetic.main.activity_main_two.*
import java.util.*
import kotlin.concurrent.timer

class activity_main_two : AppCompatActivity() {

    var retornoPage: Long = 0L
    var editPreferencias: SharedPreferences.Editor? = null
    var preferencias: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_two)

        tvEmail.text = intent.getStringExtra("email")

        preferencias = getSharedPreferences("Estudos", Context.MODE_PRIVATE)
        editPreferencias = preferencias?.edit()

        val timer = object : CountDownTimer(9000, 3000) {
            override fun onFinish() {
                tvEmail.visibility = View.GONE
                ivImagem.visibility = View.GONE
                tvResposta.visibility = View.VISIBLE
                tvResposta.text = "Tempo esgotado!"

                Timer().schedule(object : TimerTask() {
                    override fun run() {}
                }, 5000)
                val threeActivity = Intent(this@activity_main_two, activity_main_three::class.java)
                startActivity(threeActivity)
            }

            override fun onTick(millisUntilFinished: Long) {
                val imagem = if (millisUntilFinished < 3000L) {
                    R.drawable.docinho
                } else if (millisUntilFinished < 6000L) {
                    R.drawable.florzinha
                } else {
                    R.drawable.lindinha
                }
                ivImagem.setImageDrawable(getDrawable(imagem))
            }

        }
        timer.start()

    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - retornoPage > 2000) {
            Toast.makeText(this, "Clique novamente p/ sair", Toast.LENGTH_SHORT).show()
            retornoPage = System.currentTimeMillis()
        } else {
            editPreferencias?.putBoolean("autenticado", false)
            editPreferencias?.commit()
            super.onBackPressed()
        }
    }
}
