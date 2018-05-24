package com.testtask.santa.core.utils.exceptions


data class DataException(
    val code: Long
): RuntimeException()
