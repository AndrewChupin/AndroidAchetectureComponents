package com.testtask.santa.core.data.mapper


interface Mappable<out To> {

    fun map(): To

}
