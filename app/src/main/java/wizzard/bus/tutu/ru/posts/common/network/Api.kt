package wizzard.bus.tutu.ru.posts.common.network

import retrofit2.http.GET
import wizzard.bus.tutu.ru.posts.data.words.entity.WordDto


interface Api {

    @GET
    fun loadAllWords(): List<WordDto>

}
