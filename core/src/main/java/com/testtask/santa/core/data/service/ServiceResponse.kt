package com.testtask.santa.core.data.service

import com.squareup.moshi.Json
import com.testtask.santa.core.utils.exceptions.DataException

sealed class ResponseResult<ResponseType> {
    data class Success<ResponseType>(
        @Json(name = "name")
        val data: ResponseType
    ) : ResponseResult<ResponseType>()

    data class Error<ResponseType>(
        @Json(name = "code")
        val code: Long
    ) : ResponseResult<ResponseType>()

    data class Exception<ResponseType>(
        val error: Throwable
    ) : ResponseResult<ResponseType>()


    fun handleDefault(): ResponseType = when(this) {
        is ResponseResult.Success -> this.data
        is ResponseResult.Error -> throw DataException(this.code)
        is ResponseResult.Exception -> throw this.error
    }
}


data class ServerResponse<out ResponseType>(
    @Json(name = "code")
    val code: Long = 0,

    @Json(name = "data")
    val data: ResponseType
)
