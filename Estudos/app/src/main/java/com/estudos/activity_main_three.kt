package com.estudos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.estudos.model.JsonPlaceHolder
import com.estudos.request.LerRetorno
import kotlinx.android.synthetic.main.activity_main_three.*

class activity_main_three : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_three)

        val task = LerRetorno()
        val jsonPlace: JsonPlaceHolder? = task.execute(10).get()

        tvJson.setText(jsonPlace?.body)
    }

}
