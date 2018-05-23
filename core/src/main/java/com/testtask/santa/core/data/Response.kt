package com.testtask.santa.core.data

import com.squareup.moshi.Json

sealed class Result<ResponseType> {
    data class Success<ResponseType>(
        @Json(name = "name")
        val data: ResponseType
    ) : Result<ResponseType>()

    data class Error<ResponseType>(
        @Json(name = "code")
        val code: Long
    ) : Result<ResponseType>()

    data class Exception<ResponseType>(
        val error: Throwable
    ) : Result<ResponseType>()
}


data class ServerResponse<out ResponseType>(
    @Json(name = "code")
    val code: Long = 0,

    @Json(name = "data")
    val data: ResponseType
)
