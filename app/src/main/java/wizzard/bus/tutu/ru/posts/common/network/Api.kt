package wizzard.bus.tutu.ru.posts.common.network

import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import wizzard.bus.tutu.ru.posts.data.word.common.WordDto


interface Api {

    @GET("/")
    fun loadAllWords(): Deferred<List<WordDto>>

}
