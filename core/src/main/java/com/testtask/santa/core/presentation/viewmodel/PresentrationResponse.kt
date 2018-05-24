package com.testtask.santa.core.presentation.viewmodel

import com.squareup.moshi.Json

sealed class ResponseResult<ResponseType> {
    data class Success<ResponseType>(
        @Json(name = "name")
        val data: ResponseType
    ) : ResponseResult<ResponseType>()

    data class Exception<ResponseType>(
        val error: Throwable
    ) : ResponseResult<ResponseType>()
}
