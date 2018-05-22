package com.testtask.santa.core.data.repository

interface CurdRepository<Model> {

    fun insertAll(entities: List<Model>)

    fun deleteAll()

    fun findAll(): List<Model>

    fun count(): Int

}
