package wizzard.bus.tutu.ru.posts.common.network

import com.testtask.santa.core.data.service.Result
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import wizzard.bus.tutu.ru.posts.data.word.common.WordDto


interface Api {

    @GET("/")
    fun loadAllWords(): Deferred<Result<List<WordDto>>>

}
