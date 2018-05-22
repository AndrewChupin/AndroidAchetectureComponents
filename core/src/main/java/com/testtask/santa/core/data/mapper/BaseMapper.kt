package com.testtask.santa.core.data.mapper


interface BaseMapper<in From, out To> {

    fun map(from: From): To

}