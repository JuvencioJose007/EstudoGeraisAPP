package com.estudos.request

import com.estudos.model.JsonPlaceHolder
import feign.Param
import feign.RequestLine

interface requisicoesNumber {

    @RequestLine("GET /posts/{id}")
    fun getNumber(@Param("id")id: Int): JsonPlaceHolder
}