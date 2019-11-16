package com.estudos.request

import android.os.AsyncTask
import com.estudos.model.JsonPlaceHolder
import feign.Feign
import feign.gson.GsonDecoder

class LerRetorno : AsyncTask<Int, Void, JsonPlaceHolder>() {
    override fun doInBackground(vararg params: Int?): JsonPlaceHolder? {
        val request = Feign.builder()
            .decoder(GsonDecoder())
            .target(
                requisicoesNumber::class.java,
                "https://jsonplaceholder.typicode.com/"
            )

        try {
            return request.getNumber(params[0]!!)
        } catch (e: Exception) {
            return null
        }
    }
}