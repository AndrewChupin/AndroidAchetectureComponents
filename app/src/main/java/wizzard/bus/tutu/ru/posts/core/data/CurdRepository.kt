package wizzard.bus.tutu.ru.posts.core.data

interface CurdRepository<Model, in Id> {

    fun create(model: Model)

    fun update(model: Model)

    fun delete(model: Model)

    fun find(id: Id): List<Model>

}
